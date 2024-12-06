package com.system_dashboard.system_dashboard.scheduler;

import com.fasterxml.jackson.core.type.TypeReference;
import com.system_dashboard.system_dashboard.models.IOTAirData;
import com.system_dashboard.system_dashboard.models.IOTAirDevice;
import com.system_dashboard.system_dashboard.repositories.IOTAirDataRespository;
//import com.system_dashboard.system_dashboard.repositories.IOTAirDeviceRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.*;
import java.io.File;
@Component
public class AirDataScheduler {

    //@Autowired
    //private IOTAirDeviceRespository iotAirDeviceRespository;
    ObjectMapper objectMapper = new ObjectMapper();
    //Change file path of using localhost
    //Current file path relative to container
    File dataFile = new File("airDevices.json");
    List<IOTAirDevice> airDevices;
    {
        //read devices from json file, if error throw error
        try {
            airDevices = objectMapper.readValue(dataFile, new TypeReference<List<IOTAirDevice>>() {
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Autowired
    private IOTAirDataRespository iotAirDataRespository;

    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${air.api.url}")
    private String airDataUrl;

    @Value("${air.api.key}")
    String airApiKey;
    @Scheduled(cron = "0 5 8-20 * * ?") // Every hour starting at 5 minutes past the hour, between 8 AM and 8 PM
    public void getAirDataFromApiAndStore() {
        try {
            // Retrieve iot devices from mongodb file
            //List<IOTAirDevice> airDevices = iotAirDeviceRespository.findAll();


            for (IOTAirDevice device : airDevices) {
                // Get location from iot device
                String[] locationParts = device.getLocation().split(",");
                double latitude = Double.parseDouble(locationParts[0]);
                double longitude = Double.parseDouble(locationParts[1]);

                // Data that will be sent to api
                Map<String, Object> payload = new HashMap<>();
                payload.put("universalAqi", true);
                Map<String, Double> locationMap = new HashMap<>();
                locationMap.put("latitude", latitude);
                locationMap.put("longitude", longitude);
                payload.put("location", locationMap);
                payload.put("extraComputations", List.of("POLLUTANT_CONCENTRATION"));

                // json format
                ObjectMapper objectMapper = new ObjectMapper();
                String jsonPayload = objectMapper.writeValueAsString(payload);

                // Set headers
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                HttpEntity<String> entity = new HttpEntity<>(jsonPayload, headers);

                // Full Url
                String fullUrl = String.format("%s:lookup?key=%s", airDataUrl, airApiKey);

                //Set default value for response
                String airDataFromApi= "0";

                // Fecth data, if error store default value, else store response
                try{
                    ResponseEntity<String> response = restTemplate.exchange(fullUrl, HttpMethod.POST, entity, String.class);
                    if(response.getStatusCode().is2xxSuccessful()){
                        airDataFromApi = response.getBody();
                    }
                } catch(Exception e){
                    System.out.println("Error retrieving data from API");
                }

                // Create airdata objects and store response
                IOTAirData airData = new IOTAirData();
                airData.setDeviceIdNo(device.getDeviceIdNo());
                airData.setName(device.getName());
                airData.setLocation(device.getLocation());
                airData.setMajorRoad(device.getMajorRoad());
                airData.setAirData(airDataFromApi);
                airData.setAirDataTimeRetrieved(new Date());
                iotAirDataRespository.save(airData);  
            }

        } catch (Exception e) {
            System.out.println("Error with retrieving air devices");
        }
    }
}

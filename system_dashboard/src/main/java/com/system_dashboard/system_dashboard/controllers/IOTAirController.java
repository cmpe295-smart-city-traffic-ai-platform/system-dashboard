package com.system_dashboard.system_dashboard.controllers;

import com.system_dashboard.system_dashboard.models.IOTAirData;
import com.system_dashboard.system_dashboard.repositories.IOTAirDataRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.*;
import java.util.ArrayList;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/api/v1/airdata/")
public class IOTAirController
{
    @Autowired
    private IOTAirDataRespository iotairDataRespository;

    /*------------------------------
   --------------IOT AIR DATA--------------
   ------------------------------*/
    //Get today's air data history for an iot prediction device
    @GetMapping("/device/{deviceIdNo}")
    public ResponseEntity<ArrayList<IOTAirData>> getDeviceLatestAirData(@PathVariable Integer deviceIdNo){
        //get air data using local time of LA
        ZoneId zoneId = ZoneId.of("America/Los_Angeles");
        LocalDate today = LocalDate.now(zoneId);
        LocalDateTime start = today.atStartOfDay();
        LocalDateTime end = today.atTime(LocalTime.MAX);
        //convert localtime to UTC since its the value stored for airtimeretrieved
        ZonedDateTime s = start.atZone(zoneId).withZoneSameInstant(ZoneId.of("UTC"));
        ZonedDateTime e = end.atZone(zoneId).withZoneSameInstant(ZoneId.of("UTC"));
        ArrayList<IOTAirData> airData = iotairDataRespository.findByDeviceIdNoAndAirDataTimeRetrievedBetween(deviceIdNo, s.toInstant(), e.toInstant(), Sort.by(Sort.Direction.ASC, "airDataTimeRetrieved"));
        return new ResponseEntity<>(airData, HttpStatus.OK);
    }
}

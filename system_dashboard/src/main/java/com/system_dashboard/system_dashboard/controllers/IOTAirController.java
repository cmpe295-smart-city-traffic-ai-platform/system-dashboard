package com.system_dashboard.system_dashboard.controllers;

import com.system_dashboard.system_dashboard.models.IOTAirData;
import com.system_dashboard.system_dashboard.repositories.IOTAirDataRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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
        LocalDate today = LocalDate.now();
        LocalDateTime start = today.atStartOfDay();
        LocalDateTime end = today.atTime(LocalTime.MAX);

        ArrayList<IOTAirData> airData = iotairDataRespository.findByDeviceIdNoAndAirDataTimeRetrievedBetween(deviceIdNo, start, end, Sort.by(Sort.Direction.ASC, "airDataTimeRetrieved"));
        return new ResponseEntity<>(airData, HttpStatus.OK);
    }
}

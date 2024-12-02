package com.system_dashboard.system_dashboard.repositories;

import com.system_dashboard.system_dashboard.models.IOTAirData;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;

import java.util.ArrayList;

public interface IOTAirDataRespository extends MongoRepository<IOTAirData, String> {
    ArrayList<IOTAirData> findByDeviceIdNoAndAirDataTimeRetrievedBetween(
            Integer deviceIdNo, LocalDateTime start, LocalDateTime end, Sort sort
    );
}

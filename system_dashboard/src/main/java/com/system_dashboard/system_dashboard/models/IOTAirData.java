package com.system_dashboard.system_dashboard.models;

import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "airData")
public class IOTAirData {
    @Id
    private String id;
    private Integer deviceIdNo;
    private String name;
    private String location;
    private String majorRoad;
    private Date airDataTimeRetrieved;
    private String airData;

    public IOTAirData() {

    }

    public IOTAirData(String id, Integer deviceIdNo, String name, String location, String majorRoad, Date airDataTimeRetrieved, String airData) {
        this.id = id;
        this.deviceIdNo = deviceIdNo;
        this.name = name;
        this.location = location;
        this.majorRoad = majorRoad;
        this.airDataTimeRetrieved = airDataTimeRetrieved;
        this.airData = airData;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public Integer getDeviceIdNo() {
        return deviceIdNo;
    }
    public void setDeviceIdNo(Integer deviceIdNo) {
        this.deviceIdNo = deviceIdNo;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public String getMajorRoad() {
        return majorRoad;
    }
    public void setMajorRoad(String majorRoad) {
        this.majorRoad = majorRoad;
    }
    public String getAirData() {
        return airData;
    }
    public void setAirData(String airData) {
        this.airData = airData;
    }
    public Date getAirDataTimeRetrieved() {
        return airDataTimeRetrieved;
    }
    public void setAirDataTimeRetrieved(Date airDataTimeRetrieved) {
        this.airDataTimeRetrieved = airDataTimeRetrieved;
    }

}

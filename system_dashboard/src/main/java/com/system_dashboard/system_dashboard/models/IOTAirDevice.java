package com.system_dashboard.system_dashboard.models;

import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "airDevices")
public class IOTAirDevice {
    @Id
    private String id;
    private Integer deviceIdNo;
    private String name;
    private String location;
    private String majorRoad;

    public IOTAirDevice() {

    }

    public IOTAirDevice(String id, Integer deviceIdNo, String name, String location, String majorRoad) {
        this.id = id;
        this.deviceIdNo = deviceIdNo;
        this.name = name;
        this.location = location;
        this.majorRoad = majorRoad;
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

}

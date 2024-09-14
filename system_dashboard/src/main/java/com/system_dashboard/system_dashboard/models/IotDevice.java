package com.system_dashboard.system_dashboard.models;
import jakarta.persistence.*;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "iot_devices")
public class IotDevice{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID deviceId;

    private String name;

    private Boolean active;

    @Temporal(TemporalType.DATE)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdTime;


    public IotDevice(){

    }

    public IotDevice(String name, Boolean active, Date createdDate, Date createdTime){

        this.name = name;
        this.active = active;
        this.createdDate = createdDate;
        this.createdTime = createdTime;
    }

    public UUID getDeviceId(){
        return deviceId;
    }
    public void setDeviceId(UUID deviceId) {
        this.deviceId = deviceId;
    }
    @Column(name = "name", nullable= false)
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    @Column(name = "active", nullable= false)
    public Boolean getIsActive(){
        return active;
    }
    public void setIsActive(Boolean isActive){
        this.active = active;
    }
    @Column(name = "created_date", nullable= false)
    public Date getCreatedAt(){
        return createdDate;
    }
    public void setCreatedAt(Date createdDate){
        this.createdDate = createdDate;
    }
    @Column(name = "created_time", nullable= false)
    public Date getCreatedAtTimestamp(){
        return createdTime;
    }
    public void setCreatedAtTimestamp(Date createdTime){
        this.createdTime = createdTime;
    }
}

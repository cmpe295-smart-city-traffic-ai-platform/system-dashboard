package com.system_dashboard.system_dashboard.services;

import com.system_dashboard.system_dashboard.models.User;
import com.system_dashboard.system_dashboard.repositories.UserRepository;

import com.system_dashboard.system_dashboard.models.IotDevice;
import com.system_dashboard.system_dashboard.repositories.IotDeviceRepository;

import com.system_dashboard.system_dashboard.models.DroneDevice;
import com.system_dashboard.system_dashboard.repositories.DroneRepository;

import com.system_dashboard.system_dashboard.models.CctvDevice;
import com.system_dashboard.system_dashboard.repositories.CctvDeviceRepository;

import java.util.ArrayList;
import java.util.UUID;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.couchbase.CouchbaseProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class DashboardServiceImpl implements DashboardService{

    private final UserRepository userRepository;
    private final IotDeviceRepository iotDeviceRepository;
    private final DroneRepository droneRepository;
    private final CctvDeviceRepository cctvDeviceRepository;

    @Autowired 
    public DashboardServiceImpl(UserRepository userRepository, IotDeviceRepository iotDeviceRepository, DroneRepository droneRepository, CctvDeviceRepository cctvDeviceRepository) {
        this.userRepository = userRepository;
        this.iotDeviceRepository = iotDeviceRepository;
        this.droneRepository = droneRepository;
        this.cctvDeviceRepository = cctvDeviceRepository;
    }
    /*------------------------------
    --------------USER--------------
    ------------------------------*/
    @Override
    public User createUser(User user) {
        // create a new user
        return this.userRepository.save(user);
    }

    @Override
    public ArrayList<User> getAllUsers() {
        // return all users
        return this.userRepository.findAll();
    }

    @Override
    public ArrayList<User> getUserByID(UUID userId) {
        // return user that matches specific id
        return this.userRepository.findUserByUserId(userId);
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return this.userRepository.findUserByEmail(email);
    }

    /*------------------------------
    --------------IOT DEVICES--------------
    ------------------------------*/
    @Override
    public ArrayList<IotDevice> getAllIotDevices() {
        return this.iotDeviceRepository.findAll();
    }

    @Override
    public ArrayList<IotDevice> getIotDeviceByDeviceId(UUID deviceId) {
        return this.iotDeviceRepository.findIotDeviceByDeviceId(deviceId);
    }

    @Override
    public Optional<IotDevice> getIotDeviceByName(String name) {
        return this.iotDeviceRepository.findIotDeviceByName(name);
    }

    @Override
    public ArrayList<IotDevice> getAllActiveIotDevices() {
        return this.iotDeviceRepository.findByActiveTrue();
    }
    @Override
    public ArrayList<IotDevice> getAllInactiveIotDevices() {
        return this.iotDeviceRepository.findByActiveFalse();
    }

    /*------------------------------
    --------------DRONE DEVICES--------------
    ------------------------------*/
    @Override
    public ArrayList<DroneDevice> getAllDroneDevices() {
        return this.droneRepository.findAll();
    }
    @Override
    public ArrayList<DroneDevice> getDroneDeviceByDeviceId(UUID deviceId) {
        return this.droneRepository.findDroneDeviceByDeviceId(deviceId);
    }
    @Override
    public Optional<DroneDevice> getDroneDeviceByName(String name) {
        return this.droneRepository.findDroneDeviceByName(name);
    }
    @Override
    public ArrayList<DroneDevice> getAllActiveDroneDevices() {
        return this.droneRepository.findByActiveTrue();
    }
    @Override
    public ArrayList<DroneDevice> getAllInactiveDroneDevices() {
        return this.droneRepository.findByActiveFalse();
    }

    /*------------------------------
    --------------CCTV DEVICES--------------
    ------------------------------*/
    @Override
    public ArrayList<CctvDevice> getAllCctvDevices() {
        return this.cctvDeviceRepository.findAll();
    }
    @Override
    public ArrayList<CctvDevice> getCctvDeviceByDeviceId(UUID deviceId) {
        return this.cctvDeviceRepository.findCctvDeviceByDeviceId(deviceId);
    }
    @Override
    public Optional<CctvDevice> getCctvDeviceByName(String name) {
        return this.cctvDeviceRepository.findCctvDeviceByName(name);
    }
    @Override
    public ArrayList<CctvDevice> getAllActiveCctvDevices() {
        return this.cctvDeviceRepository.findByActiveTrue();
    }
    @Override
    public ArrayList<CctvDevice> getAllInactiveCctvDevices() {
        return this.cctvDeviceRepository.findByActiveFalse();
    }



}

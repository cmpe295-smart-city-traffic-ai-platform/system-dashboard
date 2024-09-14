package com.system_dashboard.system_dashboard.controllers;

import com.system_dashboard.system_dashboard.models.CctvDevice;
import com.system_dashboard.system_dashboard.models.DroneDevice;
import com.system_dashboard.system_dashboard.models.IotDevice;
import com.system_dashboard.system_dashboard.models.User;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import com.system_dashboard.system_dashboard.services.DashboardServiceImpl;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/api/dashboard/")
public class DashboardController {
    DashboardServiceImpl dashboardService;

    @Autowired
    DashboardController(DashboardServiceImpl dashboardService){
        this.dashboardService = dashboardService;
    }

    @GetMapping("/users")
    public ResponseEntity<ArrayList<User>> getAllUsers(){
        ArrayList<User> users = this.dashboardService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    @GetMapping("/users/{email}")
    public ResponseEntity<Optional<User>> getSingleUser(@PathVariable String email){
        Optional<User> user = this.dashboardService.getUserByEmail(email);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
        User newUser = new User( user.getFirstName(),
            user.getLastName(), user.getEmail(), user.getRole());
            this.dashboardService.createUser(newUser);
            return new ResponseEntity<>(newUser, HttpStatus.OK);
    }
    @GetMapping("/iot")
    public ResponseEntity<ArrayList<IotDevice>> getAllIotDevices(){
        ArrayList<IotDevice> iotDevices = this.dashboardService.getAllIotDevices();
        return new ResponseEntity<>(iotDevices, HttpStatus.OK);
    }
    @GetMapping("/iot/{name}")
    public ResponseEntity<Optional<IotDevice>> getSingleIotDevice(@PathVariable String name){
        Optional<IotDevice> iotDevice = this.dashboardService.getIotDeviceByName(name);
        return new ResponseEntity<>(iotDevice, HttpStatus.OK);
    }
    @GetMapping("/cctv")
    public ResponseEntity<ArrayList<CctvDevice>> getAllCctvDevices(){
        ArrayList<CctvDevice> cctvDevices = this.dashboardService.getAllCctvDevices();
        return new ResponseEntity<>(cctvDevices, HttpStatus.OK);
    }
    @GetMapping("/cctv/{name}")
    public ResponseEntity<Optional<CctvDevice>> getSingleCctvDevice(@PathVariable String name){
        Optional<CctvDevice> cctvDevice = this.dashboardService.getCctvDeviceByName(name);
        return new ResponseEntity<>(cctvDevice, HttpStatus.OK);
    }
    @GetMapping("/drone")
    public ResponseEntity<ArrayList<DroneDevice>> getAllDroneDevices(){
        ArrayList<DroneDevice> droneDevices = this.dashboardService.getAllDroneDevices();
        return new ResponseEntity<>(droneDevices, HttpStatus.OK);
    }
    @GetMapping("/drone/{name}")
    public ResponseEntity<Optional<DroneDevice>> getSingleDroneDevice(@PathVariable String name){
        Optional<DroneDevice> droneDevice = this.dashboardService.getDroneDeviceByName(name);
        return new ResponseEntity<>(droneDevice, HttpStatus.OK);
    }



}

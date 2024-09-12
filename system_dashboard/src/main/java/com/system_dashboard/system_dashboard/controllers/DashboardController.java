package com.system_dashboard.system_dashboard.controllers;

import com.system_dashboard.system_dashboard.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import com.system_dashboard.system_dashboard.services.DashboardServiceImpl;

@RestController
@RequestMapping("/api/dashboard/")
public class DashboardController {
    DashboardServiceImpl dashboardService;

    @Autowired
    DashboardController(DashboardServiceImpl dashboardService){
        this.dashboardService = dashboardService;
    }
    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
        User newUser = new User(user.getUserId(), user.getFirstName(), 
            user.getLastName(), user.getEmail(), user.getRole());
            this.dashboardService.createUser(newUser);
            return new ResponseEntity<>(newUser, HttpStatus.OK);
    }

}

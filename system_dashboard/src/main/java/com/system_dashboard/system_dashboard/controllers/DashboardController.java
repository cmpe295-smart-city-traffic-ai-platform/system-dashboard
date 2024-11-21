package com.system_dashboard.system_dashboard.controllers;

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

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/api/v1/dashboard/")
public class DashboardController {
    DashboardServiceImpl dashboardService;

    @Autowired
    DashboardController(DashboardServiceImpl dashboardService){
        this.dashboardService = dashboardService;
    }
    /*------------------------------
    --------------USER--------------
    ------------------------------*/
    @GetMapping("/user")
    public ResponseEntity<ArrayList<User>> getAllUsers(){
        ArrayList<User> users = this.dashboardService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    //Login using email and password
    @PostMapping("/user/login")
    public ResponseEntity<Optional<User>> getSingleUser(@Valid @RequestBody User user){
        Optional<User> profile = this.dashboardService.getUserByEmail(user.getEmail());
        //if email & password matching an existing account, send user info
        if(profile.isPresent() && user.getPassword().equals(profile.get().getPassword())){
            //return user information
            return new ResponseEntity<>(profile, HttpStatus.OK);
        }
        //user was not found matching email
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }
    //Register new account
    @PostMapping("/user/register")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
        Optional<User> profile = this.dashboardService.getUserByEmail(user.getEmail());
        //if email matching an existing account, send error
        if(profile.isPresent()){
            //System.out.println("Profile was found");
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        //else create new user
        User newUser = new User( user.getFirstName(),
            user.getLastName(), user.getEmail(), user.getRole(), user.getPassword());
            this.dashboardService.createUser(newUser);
            return new ResponseEntity<>(newUser, HttpStatus.OK);
    }
    //Update user information
    @PostMapping("/user/update")
    public ResponseEntity<User> updateUser(@Valid @RequestBody User user){
        User profile = this.dashboardService.updateUser(user);
        return new ResponseEntity<>(profile, HttpStatus.OK);
    }

}

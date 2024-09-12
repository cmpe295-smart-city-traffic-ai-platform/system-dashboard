package com.system_dashboard.system_dashboard.services;

import com.system_dashboard.system_dashboard.models.User;
import com.system_dashboard.system_dashboard.repositories.UserRepository;

import java.util.ArrayList;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class DashboardServiceImpl implements DashboardService{

    private UserRepository userRepository;
    
    @Autowired 
    public DashboardServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    
    
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
    
}

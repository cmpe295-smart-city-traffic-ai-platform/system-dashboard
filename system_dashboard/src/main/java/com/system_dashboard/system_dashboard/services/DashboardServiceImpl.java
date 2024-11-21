package com.system_dashboard.system_dashboard.services;

import com.system_dashboard.system_dashboard.models.User;
import com.system_dashboard.system_dashboard.repositories.UserRepository;

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

    @Autowired 
    public DashboardServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;//LOGIN
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

    @Override
    public User updateUser(User user) {
        Optional<User> oldAccount = this.userRepository.findUserByEmail(user.getEmail());
        User updatedAccount = oldAccount.get();
        //if password is not empty, change it
        if(user.getPassword() != null) {
            updatedAccount.setPassword(user.getPassword());
        }
        //if first name is not empty, change it
        if(user.getFirstName() != null) {
            updatedAccount.setFirstName(user.getFirstName());
        }
        //if last name is not empty, change it
        if(user.getLastName() != null) {
            updatedAccount.setLastName(user.getLastName());
        }
        //return updated user
        return this.userRepository.save(updatedAccount);
    }
}

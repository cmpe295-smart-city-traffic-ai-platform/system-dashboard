package com.system_dashboard.system_dashboard.services;

import com.system_dashboard.system_dashboard.models.User;

import java.util.ArrayList;
import java.util.UUID;

public interface DashboardService {
   User createUser(User user);
   ArrayList<User> getAllUsers();
   ArrayList<User> getUserByID(UUID userId);
    

}

package com.system_dashboard.system_dashboard.services;

import com.system_dashboard.system_dashboard.models.User;
import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

public interface DashboardService {
   /*------------------------------
    --------------USER--------------
    ------------------------------*/
   User createUser(User user);
   ArrayList<User> getAllUsers();
   ArrayList<User> getUserByID(UUID userId);
   Optional<User> getUserByEmail(String email);
   User updateUser(User user);

}

package com.system_dashboard.system_dashboard.services;

import com.system_dashboard.system_dashboard.models.CctvDevice;
import com.system_dashboard.system_dashboard.models.User;
import com.system_dashboard.system_dashboard.models.IotDevice;
import com.system_dashboard.system_dashboard.models.DroneDevice;
import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

public interface DashboardService {
   User createUser(User user);
   ArrayList<User> getAllUsers();
   ArrayList<User> getUserByID(UUID userId);
   Optional<User> getUserByEmail(String email);

   ArrayList<IotDevice> getAllIotDevices();
   ArrayList<IotDevice> getIotDeviceByDeviceId(UUID deviceId);
   Optional<IotDevice> getIotDeviceByName(String name);

   ArrayList<DroneDevice> getAllDroneDevices();
   ArrayList<DroneDevice> getDroneDeviceByDeviceId(UUID deviceId);
   Optional<DroneDevice> getDroneDeviceByName(String name);

   ArrayList<CctvDevice> getAllCctvDevices();
   ArrayList<CctvDevice> getCctvDeviceByDeviceId(UUID deviceId);
   Optional<CctvDevice> getCctvDeviceByName(String name);
}

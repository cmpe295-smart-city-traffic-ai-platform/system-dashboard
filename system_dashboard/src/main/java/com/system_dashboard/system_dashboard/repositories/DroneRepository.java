package com.system_dashboard.system_dashboard.repositories;

import com.system_dashboard.system_dashboard.models.DroneDevice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface DroneRepository extends JpaRepository<DroneDevice, UUID> {
    ArrayList<DroneDevice> findDroneDeviceByDeviceId(UUID deviceId);
    ArrayList<DroneDevice> findAll();
    Optional<DroneDevice> findDroneDeviceByName(String name);
    ArrayList<DroneDevice> findByActiveTrue();
    ArrayList<DroneDevice> findByActiveFalse();
}

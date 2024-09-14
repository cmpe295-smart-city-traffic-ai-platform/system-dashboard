package com.system_dashboard.system_dashboard.repositories;

import com.system_dashboard.system_dashboard.models.IotDevice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface IotDeviceRepository extends JpaRepository<IotDevice, UUID> {
    ArrayList<IotDevice> findIotDeviceByDeviceId(UUID deviceId);
    ArrayList<IotDevice> findAll();
    Optional<IotDevice> findIotDeviceByName(String name);
}

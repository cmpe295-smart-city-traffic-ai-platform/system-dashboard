package com.system_dashboard.system_dashboard.repositories;

import com.system_dashboard.system_dashboard.models.CctvDevice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CctvDeviceRepository extends JpaRepository<CctvDevice, UUID> {
    ArrayList<CctvDevice> findCctvDeviceByDeviceId(UUID deviceId);
    ArrayList<CctvDevice> findAll();
    Optional<CctvDevice> findCctvDeviceByName(String name);
    ArrayList<CctvDevice> findByActiveTrue();
    ArrayList<CctvDevice> findByActiveFalse();
}

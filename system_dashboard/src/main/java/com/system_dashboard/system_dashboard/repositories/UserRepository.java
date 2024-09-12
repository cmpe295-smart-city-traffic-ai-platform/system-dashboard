package com.system_dashboard.system_dashboard.repositories;

import com.system_dashboard.system_dashboard.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
import java.util.ArrayList;
@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    ArrayList<User> findUserByUserId(UUID userId);
    ArrayList<User> findAll();

}

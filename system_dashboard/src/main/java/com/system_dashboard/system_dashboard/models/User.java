package com.system_dashboard.system_dashboard.models;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.annotation.Nullable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import java.util.Date;
import java.util.UUID;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID userId;
    
    private String firstName;
    
    private String lastName;
    
    private String email;
    
    private String role;
    
    public User(){

    }

    public User(UUID userId, String firstName, String lastName, String email, String role){
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.role = role;
    }

    public UUID getUserId(){
        return userId;
    }
    public void setUserId(UUID userId) {
        this.userId = userId;
    }
    @Column(name = "first_name", nullable= false)
    public String getFirstName(){
        return firstName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    @Column(name = "last_name", nullable= false)
    public String getLastName(){
        return lastName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    @Column(name = "email", nullable= false)
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    @Column(name = "role", nullable= false)
    public String getRole(){
        return role;
    }
    public void setRole(String role){
        this.role = role;
    }
}

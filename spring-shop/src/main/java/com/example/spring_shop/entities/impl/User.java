package com.example.spring_shop.entities.impl;

import com.example.spring_shop.entities.inter.IUser;
import jakarta.persistence.*;

@Entity
@Table(name = "Customers")
public class User implements IUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String password;
    private String dob;
    private boolean isActive = true;

    public User(String name, String password, String dob) {
        this.name = name;
        this.password = password;
        this.dob = dob;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public boolean getActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}

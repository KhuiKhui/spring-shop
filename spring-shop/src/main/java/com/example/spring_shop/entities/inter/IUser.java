package com.example.spring_shop.entities.inter;

public interface IUser {
    int getId();

    void setId(int id);

    String getName();

    void setName(String name);

    String getDob();

    void setDob(String dob);

    boolean getActive();

    void setActive(boolean active);
}

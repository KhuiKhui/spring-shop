package com.example.spring_shop.entities.inter;

public interface IProduct {
    int getId();

    void setId(int id);

    String getName();

    void setName(String name);

    double getPrice();

    void setPrice(double price);

    boolean getActive();

    void setActive(boolean active);
}

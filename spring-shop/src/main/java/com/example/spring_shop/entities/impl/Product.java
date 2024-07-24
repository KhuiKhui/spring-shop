package com.example.spring_shop.entities.impl;

import com.example.spring_shop.entities.inter.IProduct;
import com.example.spring_shop.validation.impl.beanGroups.AddGroup;
import com.example.spring_shop.validation.impl.beanGroups.DeleteGroup;
import com.example.spring_shop.validation.impl.beanGroups.UpdateGroup;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Products")
public class Product implements IProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Positive(groups = {DeleteGroup.class, UpdateGroup.class})
    private int id;

    @Column(nullable = false)
    @Size(min = 2, max = 20, groups = {AddGroup.class, UpdateGroup.class})
    @NotNull(groups = {AddGroup.class, UpdateGroup.class})
    private String name;

    @Column(nullable = false)
    @Positive(groups = {AddGroup.class, UpdateGroup.class})
    @NotNull(groups = {AddGroup.class, UpdateGroup.class})
    private double price;

    private boolean isActive = true;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }


    public Product() {
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean getActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "{" +
                "id: " + id +
                ", name: '" + name + '\'' +
                ", price: " + price +
                ", isActive: " + isActive +
                '}';
    }
}

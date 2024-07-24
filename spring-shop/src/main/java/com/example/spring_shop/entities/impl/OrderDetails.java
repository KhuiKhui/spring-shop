package com.example.spring_shop.entities.impl;

import com.example.spring_shop.entities.inter.IOrderDetails;
import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "OrderDetails")
public class OrderDetails implements IOrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Positive
    private int orderId;
    @Positive
    private int productId;
    @Positive
    private double price;
    @Positive
    private int quantity;

    public OrderDetails(int orderId, int productId, double price, int quantity) {
        this.orderId = orderId;
        this.productId = productId;
        this.price = price;
        this.quantity = quantity;
    }

    public OrderDetails() {
    }

    @Override
    @Positive
    public int getOrderId() {
        return orderId;
    }

    @Override
    public void setOrderId(@Positive int orderId) {
        this.orderId = orderId;
    }

    @Override
    @Positive
    public int getProductId() {
        return productId;
    }

    @Override
    public void setProductId(@Positive int productId) {
        this.productId = productId;
    }

    @Override
    @Positive
    public double getPrice() {
        return price;
    }

    @Override
    public void setPrice(@Positive double price) {
        this.price = price;
    }

    @Override
    @Positive
    public int getQuantity() {
        return quantity;
    }

    @Override
    public void setQuantity(@Positive int quantity) {
        this.quantity = quantity;
    }
}

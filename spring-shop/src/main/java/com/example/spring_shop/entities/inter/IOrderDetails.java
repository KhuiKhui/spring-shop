package com.example.spring_shop.entities.inter;

import jakarta.validation.constraints.Positive;

public interface IOrderDetails {
    @Positive
    int getOrderId();

    void setOrderId(@Positive int orderId);

    @Positive
    int getProductId();

    void setProductId(@Positive int productId);

    @Positive
    double getPrice();

    void setPrice(@Positive double price);

    @Positive
    int getQuantity();

    void setQuantity(@Positive int quantity);
}

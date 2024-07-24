package com.example.spring_shop.services.inter;

import com.example.spring_shop.components.CartItem;
import com.example.spring_shop.response.ResponseData;

import java.util.Collection;

public interface IOrderService {
    double getTotal(Collection<CartItem> items);

    String getDesc(Collection<CartItem> items);

    ResponseData createOrder(Collection<CartItem> items, int userId);
}

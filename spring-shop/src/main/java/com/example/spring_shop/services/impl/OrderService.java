package com.example.spring_shop.services.impl;

import com.example.spring_shop.components.CartItem;
import com.example.spring_shop.entities.impl.Order;
import com.example.spring_shop.repos.OrderRepository;
import com.example.spring_shop.response.ErrorStatus;
import com.example.spring_shop.response.ResponseData;
import com.example.spring_shop.services.inter.IOrderService;
import com.example.spring_shop.validation.impl.ServiceValidation;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;

@Service
public class OrderService implements IOrderService {

    private final OrderRepository orderRepository;
    private final ServiceValidation validator;

    public OrderService(OrderRepository orderRepository, ServiceValidation validator) {
        this.orderRepository = orderRepository;
        this.validator = validator;
    }


    @Override
    public double getTotal(Collection<CartItem> items) {
        double total = 0;
        for (CartItem item : items) {
            total += item.getData().getDouble("price") * item.getQuantity();
        }
        return total;
    }

    @Override
    public String getDesc(Collection<CartItem> items) {
        if (!validator.collectionCheck(items)) {
            return "";
        }
        String desc = "";
        for (CartItem item : items) {
            desc += item.getData().getString("name") + " " + item.getData().getDouble("price") + ",";
        }
        return desc.substring(0, desc.length() - 1);
    }

    @Override
    public ResponseData createOrder(Collection<CartItem> items, int userId) {
        try {
            if (!validator.collectionCheck(items) || validator.notNullCheck(userId)) {
                return new ResponseData(null, ErrorStatus.POST_METHOD_FAILED.getDesc(), ErrorStatus.POST_METHOD_FAILED.getCode());
            }
            double total = getTotal(items);
            String desc = getDesc(items);
            Order order = new Order(userId, total, desc, (new Date()).getTime());
            validator.notNullCheck(order);
            Order saved = orderRepository.save(order);
            return new ResponseData(saved.toString(), ErrorStatus.POST_METHOD_SUCCESS.getDesc(), ErrorStatus.POST_METHOD_SUCCESS.getCode());
        } catch (Exception e) {
            return new ResponseData(null, ErrorStatus.POST_METHOD_FAILED.getDesc(), ErrorStatus.POST_METHOD_FAILED.getCode());
        }
    }

}

package com.example.spring_shop.services.impl;

import com.example.spring_shop.components.CartItem;
import com.example.spring_shop.entities.impl.OrderDetails;
import com.example.spring_shop.repos.OrderDetailsRepository;
import com.example.spring_shop.response.ErrorStatus;
import com.example.spring_shop.response.ResponseData;
import com.example.spring_shop.validation.impl.ServiceValidation;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class OrderDetailsService {

    private final OrderDetailsRepository orderDetailsRepository;
    private final ServiceValidation validator;

    public OrderDetailsService(OrderDetailsRepository orderDetailsRepository, ServiceValidation validator) {
        this.orderDetailsRepository = orderDetailsRepository;
        this.validator = validator;
    }

    public ResponseData createOrderDetails(Collection<CartItem> items, ResponseData orderResponse) {
        try {
            if (validator.notNullCheck(orderResponse.getResData())) {
                return new ResponseData(null, ErrorStatus.POST_METHOD_FAILED.getDesc(), ErrorStatus.POST_METHOD_FAILED.getCode());
            }
            String test = orderResponse.getResData();
            JSONObject order = orderResponse.getJsonData();
            int orderId = order.getInt("id");
            List<OrderDetails> orderDetails = new ArrayList<>();
            for (CartItem item : items) {
                orderDetails.add(new OrderDetails(orderId, item.getData().getInt("id"), item.getData().getDouble("price"), item.getQuantity()));
            }
            List<OrderDetails> saved = orderDetailsRepository.saveAll(orderDetails);
            return new ResponseData(saved.toString(), ErrorStatus.POST_METHOD_SUCCESS.getDesc(), ErrorStatus.POST_METHOD_SUCCESS.getCode());

        } catch (Exception e) {
            return new ResponseData(null, ErrorStatus.POST_METHOD_FAILED.getDesc(), ErrorStatus.POST_METHOD_FAILED.getCode());
        }
    }
}

package com.example.spring_shop.components;

import org.json.JSONObject;

public class CartItem {
    private JSONObject data;
    private int quantity;

    public CartItem(JSONObject data, int quantity) {
        this.data = data;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void increaseQuantity() {
        this.quantity++;
    }

    public void decreaseQuantity() {
        this.quantity--;
    }

    public JSONObject getData() {
        return data;
    }

    public void setData(JSONObject data) {
        this.data = data;
    }

}

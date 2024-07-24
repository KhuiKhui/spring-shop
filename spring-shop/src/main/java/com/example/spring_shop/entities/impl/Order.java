package com.example.spring_shop.entities.impl;

import com.example.spring_shop.entities.inter.IOrder;
import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "Orders")
public class Order implements IOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Positive
    @Column
    private int userId;
    @Positive
    @Column
    private double total;

    @Column(name = "description")
    private String desc;

    @Positive
    @Column
    private long createTime;

    public Order(int userId, double total, String desc, long createTime) {
        this.userId = userId;
        this.total = total;
        this.desc = desc;
        this.createTime = createTime;
    }

    public Order() {
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    @Positive
    public int getUserId() {
        return userId;
    }

    @Override
    public void setUserId(@Positive int userId) {
        this.userId = userId;
    }

    @Override
    @Positive
    public double getTotal() {
        return total;
    }

    @Override
    public void setTotal(@Positive double total) {
        this.total = total;
    }

    @Override
    public String getDesc() {
        return desc;
    }

    @Override
    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public long getCreateTime() {
        return createTime;
    }

    @Override
    public void setCreateTime(@Positive long createTime) {
        this.createTime = createTime;
    }

    
}

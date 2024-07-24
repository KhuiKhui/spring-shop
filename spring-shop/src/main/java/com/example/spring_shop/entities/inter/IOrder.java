package com.example.spring_shop.entities.inter;

import jakarta.validation.constraints.Positive;

public interface IOrder {
    int getId();

    void setId(int id);

    @Positive
    int getUserId();

    void setUserId(@Positive int userId);

    @Positive
    double getTotal();

    void setTotal(@Positive double total);

    String getDesc();

    void setDesc(String desc);

    @Positive
    long getCreateTime();

    void setCreateTime(@Positive long createTime);
}

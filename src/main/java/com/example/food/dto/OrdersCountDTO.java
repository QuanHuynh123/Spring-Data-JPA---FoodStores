package com.example.food.dto;

import java.time.Month;

public class OrdersCountDTO {
    private Month month;
    private long orderCount;

    public OrdersCountDTO(Month month, long orderCount) {
        this.month = month;
        this.orderCount = orderCount;
    }

    // Getters and setters

    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }

    public long getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(long orderCount) {
        this.orderCount = orderCount;
    }
}
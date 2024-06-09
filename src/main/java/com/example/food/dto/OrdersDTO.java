package com.example.food.dto;

import com.example.food.entity.CustomerEntity;
import com.example.food.entity.OrderItemEntity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrdersDTO {

    private int id;
    private Date orderDate;

    private String orderNumber;

    private BigDecimal totalAmount;

    private String  customerId;

}

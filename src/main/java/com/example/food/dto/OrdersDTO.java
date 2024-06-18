package com.example.food.dto;

import com.example.food.entity.CustomerEntity;
import com.example.food.entity.OrderItemEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrdersDTO {
     int id;
     Date orderDate;
     String orderNumber;
     BigDecimal totalAmount;
     List<OrderItemDTO> orderItems;
}

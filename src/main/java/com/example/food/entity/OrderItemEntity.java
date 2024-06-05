package com.example.food.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name="orderitem")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",nullable = false)
    private  int Id;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity product;
    @Column(name="unitprice", precision = 12, scale = 2, nullable = false)
    private BigDecimal UnitPrice;
    @Column(name="quantity",nullable = false)
    private int Quantity;
    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private OrdersEntity order;

}

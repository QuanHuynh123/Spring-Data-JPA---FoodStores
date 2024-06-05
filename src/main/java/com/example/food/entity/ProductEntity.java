package com.example.food.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",nullable = false)
    private int id;

    @Column(name="productname",length = 50)
    private String ProductName;

    @Column(name="unitprice", precision = 12, scale = 2)
    private BigDecimal UnitPrice;

    @Column(name="package",length = 30)
    private String Package;

    @Column(name="isdiscontinued",nullable = false)
    private byte IsDiscontinued;

    @ManyToOne
    @JoinColumn(name = "supplier_id", nullable = false)
    private SupplierEntity supplier;

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @OneToMany(mappedBy = "product")
    private List<OrderItemEntity> orderItems;
}

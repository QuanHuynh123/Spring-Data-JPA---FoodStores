package com.example.food.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",nullable = false)
    private int id;

    @Column(name="productname",length = 50)
    private String productName;

    @Column(name="unitprice", precision = 12, scale = 2)
    private BigDecimal unitPrice;

    @Column(name="package",length = 30)
    private String packageType;

    @Column(name="isdiscontinued",nullable = false)
    private byte isDiscontinued;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supplier_id", nullable = false)
    private SupplierEntity supplier;

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @OneToMany(mappedBy = "product")
    private List<OrderItemEntity> orderItems;
}

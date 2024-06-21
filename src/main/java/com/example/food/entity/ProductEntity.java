package com.example.food.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "product")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    int id;

    @Column(name = "productname", length = 50)
    String productName;

    @Column(name = "unitprice", precision = 12, scale = 2)
    BigDecimal unitPrice;

    @Column(name = "package", length = 30)
    String packageType;

    @Column(name = "isdiscontinued", nullable = false)
    byte isDiscontinued;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supplier_id", nullable = false)
    SupplierEntity supplier;

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @OneToMany(mappedBy = "product")
    List<OrderItemEntity> orderItems;
}

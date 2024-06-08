package com.example.food.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="supplier")
public class SupplierEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",nullable = false)
    private int id;

    @Column(name="companyname",length = 40,nullable = false)
    private String companyName;

    @Column(name="contactname",length = 50)
    private String contactName;

    @Column(name="contacttitle",length = 40)
    private String contactTitle;

    @Column(name="city",length = 40)
    private String city;

    @Column(name="country",length = 40)
    private String country;

    @Column(name="phone",length = 30)
    private String phone;

    @Column(name="fax",length = 30)
    private String fax;

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductEntity> products;


}

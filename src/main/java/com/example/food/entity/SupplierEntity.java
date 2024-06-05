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
    private String CompanyName;
    @Column(name="contactname",length = 50)
    private String ContactName;
    @Column(name="contacttitle",length = 40)
    private String ContactTitle;
    @Column(name="city",length = 40)
    private String City;
    @Column(name="country",length = 40)
    private String Country;
    @Column(name="phone",length = 30)
    private String Phone;
    @Column(name="fax",length = 30)
    private String Fax;

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductEntity> products;


}

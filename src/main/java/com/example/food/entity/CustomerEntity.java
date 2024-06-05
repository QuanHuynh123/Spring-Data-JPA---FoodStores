package com.example.food.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="customer")
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",nullable = false)
    private int id;
    @Column(name="firstname",length = 40, nullable = false)
    private String FirstName;
    @Column(name="lastname", length = 40, nullable = false)
    private String LastName;
    @Column(name = "city", length = 40)
    private String City;
    @Column(name="country",length = 40)
    private String Country;
    @Column(name="phone",length = 20, nullable = false)
    private String Phone;

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @OneToMany(mappedBy = "customer")
    private List<OrdersEntity> orders;

}

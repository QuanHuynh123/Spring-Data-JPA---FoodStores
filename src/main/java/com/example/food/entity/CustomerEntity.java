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
    private String firstName;

    @Column(name="lastname", length = 40, nullable = false)
    private String lastName;

    @Column(name = "city", length = 40)
    private String city;

    @Column(name="country",length = 40)
    private String country;

    @Column(name="phone",length = 20, nullable = false)
    private String phone;
//
//    @Getter(AccessLevel.NONE)
//    @Setter(AccessLevel.NONE)
    @OneToMany(mappedBy = "customer")
    private List<OrdersEntity> orders;

}

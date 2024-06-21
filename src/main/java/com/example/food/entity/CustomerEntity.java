package com.example.food.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "customer")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    int id;

    @Column(name = "firstname", length = 40, nullable = false)
    String firstName;

    @Column(name = "lastname", length = 40, nullable = false)
    String lastName;

    @Column(name = "city", length = 40)
    String city;

    @Column(name = "country", length = 40)
    String country;

    @Column(name = "phone", length = 20, nullable = false)
    String phone;
    //
//    @Getter(AccessLevel.NONE)
//    @Setter(AccessLevel.NONE)
    @OneToMany(mappedBy = "customer")
    List<OrdersEntity> orders;

}

package com.example.food.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "supplier")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SupplierEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    int id;

    @Column(name = "companyname", length = 40, nullable = false)
    String companyName;

    @Column(name = "contactname", length = 50)
    String contactName;

    @Column(name = "contacttitle", length = 40)
    String contactTitle;

    @Column(name = "city", length = 40)
    String city;

    @Column(name = "country", length = 40)
    String country;

    @Column(name = "phone", length = 30)
    String phone;

    @Column(name = "fax", length = 30)
    String fax;

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL, orphanRemoval = true)
    List<ProductEntity> products;

}

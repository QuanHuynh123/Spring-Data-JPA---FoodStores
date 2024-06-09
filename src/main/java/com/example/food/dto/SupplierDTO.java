package com.example.food.dto;

import com.example.food.entity.ProductEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SupplierDTO {
    private int id;
    private String companyName;
    private String contactName;
    private String contactTitle;
    private String city;
    private String country;
    private String phone;
    private String fax;
}

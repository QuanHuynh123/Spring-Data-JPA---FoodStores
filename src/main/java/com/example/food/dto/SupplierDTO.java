package com.example.food.dto;

import com.example.food.entity.ProductEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SupplierDTO {
    int id;
    String companyName;
    String contactName;
    String contactTitle;
    String city;
    String country;
    String phone;
    String fax;
}

package com.example.food.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductDTO {
    @Setter(lombok.AccessLevel.NONE)
    int id;
    String productName;
    BigDecimal unitPrice;
    String packageType;
    byte isDiscontinued;
    int supplierId; // Only supplier ID, not the entire Supplier entity
}

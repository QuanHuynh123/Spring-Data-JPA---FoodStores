package com.example.food.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductDTO {
    int id;
    String productName;
    BigDecimal unitPrice;
    String packageType;
    byte isDiscontinued;
    List<SupplierDTO> suppliers;
    int supplierId; // Only supplier ID, not the entire Supplier entity
}

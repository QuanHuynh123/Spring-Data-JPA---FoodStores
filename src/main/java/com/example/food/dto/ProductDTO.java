package com.example.food.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private int id;
    private String productName;
    private BigDecimal unitPrice;
    private String packageType;
    private byte isDiscontinued;
    private int supplierId; // Only supplier ID, not the entire Supplier entity
}

package com.example.food.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class CustomerDTO {
    int id;
    String firstName;
    String lastName;
    String city;
    String country;
    String phone;
    List<OrdersDTO> orders ;
    String ordersId;
}

package com.example.food.controller;

import com.example.food.dto.ApiResponse;
import com.example.food.dto.OrdersDTO;
import com.example.food.service.OrdersService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class OrdersController {
    @Autowired
    OrdersService ordersService;

    @PostMapping
    public ApiResponse<OrdersDTO> createNewOrder(@RequestBody OrdersDTO ordersDTO) {
        return ApiResponse.<OrdersDTO>builder()
                .result(ordersService.createNewOrder(ordersDTO))
                .build();
    }
}

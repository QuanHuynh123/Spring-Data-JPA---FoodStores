package com.example.food.controller;

import com.example.food.dto.ApiResponse;
import com.example.food.dto.OrderItemDTO;
import com.example.food.dto.ProductDTO;
import com.example.food.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderItemController {

    @Autowired
    OrderItemService orderItemService;

    @GetMapping("/getAllOrderItem")
    public ApiResponse<List<OrderItemDTO>> getAllOrderItem(){
        return ApiResponse.<List<OrderItemDTO>>builder()
                .result(orderItemService.getALlOrderItem())
                .build();
    }

}

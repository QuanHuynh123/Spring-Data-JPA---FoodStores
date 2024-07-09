package com.example.food.controller;

import com.example.food.dto.OrdersCountDTO;
import com.example.food.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DashBoardController {

    @Autowired
    private OrdersService orderService;

    @GetMapping("/count-last-three-months")
    public List<OrdersCountDTO> countOrdersInLastThreeMonths() {
        return orderService.countOrdersInLastThreeMonths();
    }
}

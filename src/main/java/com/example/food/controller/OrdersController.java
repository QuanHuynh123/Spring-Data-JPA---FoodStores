package com.example.food.controller;

import com.example.food.dto.ApiResponse;
import com.example.food.dto.OrdersDTO;
import com.example.food.service.OrdersService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrdersController {
    @Autowired
    OrdersService ordersService;

    @GetMapping("/getAllOrder")
    public ApiResponse<List<OrdersDTO>> getAllOrder(){
        return ApiResponse.<List<OrdersDTO>>builder()
                .result(ordersService.getAllOrder())
                .build();
    }

    @GetMapping("/getOrderByCustomerId/{cutomerId}")
    public ApiResponse<List<OrdersDTO>> getOrderByCustomerId(@PathVariable Integer cutomerId){
        return ApiResponse.<List<OrdersDTO>>builder()
                .result(ordersService.getOrderByCustomerId(cutomerId))
                .build();
    }

    @GetMapping("/getOrderByPhone/{phone}")
    public ApiResponse<List<OrdersDTO>> getOrderByCustomerId(@PathVariable String phone){
        return ApiResponse.<List<OrdersDTO>>builder()
                .result(ordersService.getOrderByPhone(phone))
                .build();
    }

    @GetMapping("/getOrderDateAsc")
    public ApiResponse<List<OrdersDTO>> getAllOrdersOrderByDateAsc(){
        return ApiResponse.<List<OrdersDTO>>builder()
                .result(ordersService.getAllOrdersOrderByDateAsc())
                .build();
    }

    @GetMapping("/getOrderDateDesc")
    public ApiResponse<List<OrdersDTO>> getAllOrdersOrderByDateDesc(){
        return ApiResponse.<List<OrdersDTO>>builder()
                .result(ordersService.getAllOrdersOrderByDateDesc())
                .build();
    }

    @GetMapping("/excelOrder")
    public void generateExcelReportOrder(HttpServletResponse response) throws Exception{
        response.setContentType("applicatiojn/octet-steam");
        String headerKey = "Content-Disposition";
        String headerValue = "attackment;filename = foodReport.xml";

        response.setHeader(headerKey,headerValue);
        ordersService.generateExcel(response);
    }
}

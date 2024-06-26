package com.example.food.controller;

import com.example.food.dto.ApiResponse;
import com.example.food.dto.CustomerDTO;
import com.example.food.enums.ErrorCode;
import com.example.food.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("/getAllCustomer")
    public ApiResponse<List<CustomerDTO>> getAllCustomer(){
        return ApiResponse.<List<CustomerDTO>>builder()
                .result(customerService.getAllCustomer())
                .build();
    }

    @GetMapping("/findCustomerByName/{firstName}")
    public ApiResponse<List<CustomerDTO>> findCustomerByFirstName(@PathVariable  String firstName){

        return ApiResponse.<List<CustomerDTO>>builder()
                .result(customerService.findCustomerByFirstName(firstName))
                .build();
    }

    @PostMapping("/addCustomer")
    public ApiResponse<CustomerDTO> addCustomer(@RequestBody CustomerDTO customerDTO){
        return ApiResponse.<CustomerDTO>builder()
                .result(customerService.addCustomer(customerDTO))
                .build();
    }

    @PutMapping("/updateCustomer")
    public ApiResponse<CustomerDTO> updateCustomer(@RequestBody CustomerDTO customerDTO){
        return ApiResponse.<CustomerDTO>builder()
                .result(customerService.updateCustomer(customerDTO))
                .build();
    }

    @DeleteMapping("/deleteCustomer/{idCustomer}")
    public ApiResponse<String> deleteCustomer(@PathVariable int idCustomer){

        return ApiResponse.<String>builder()
                .result(customerService.deleteCustomer(String.valueOf(idCustomer)))
                .build();
    }
}

package com.example.food.controller;

import com.example.food.dto.ApiResponse;
import com.example.food.dto.CustomerDTO;
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
    public ApiResponse<CustomerDTO> addCustomer(CustomerDTO customerDTO){
        return ApiResponse.<CustomerDTO>builder()
                //.result("Show user after created")
                .message("Create customer")
                .build();
    }

    @DeleteMapping("/deleteCustomer/{idCustomer}")
    public ApiResponse<String> deleteCustomer(@PathVariable int idCustomer){

        customerService.deleteCustomer(idCustomer);
        return ApiResponse.<String>builder()
                .result("Customer deleted")
                .build();
    }
}

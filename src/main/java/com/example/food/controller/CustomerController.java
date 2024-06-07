package com.example.food.controller;

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
    public List<CustomerDTO> getAllCustomer(){
        return customerService.getAllCustomer();
    }

    @GetMapping("/findCustomerByName/{firstName}")
    public List<CustomerDTO> findCustomerByFirstName(@PathVariable  String firstName){
        return customerService.findCustomerByFirstName(firstName);
    }

    @PostMapping("/addCustomer")
    public CustomerDTO addCustomer(CustomerDTO customerDTO){
        return null;
    }

    @DeleteMapping("/deleteCustomer/{firstName}")
    public boolean deleteCustomer(@PathVariable String firstName){
        return true;
    }
}

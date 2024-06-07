package com.example.food.service;

import com.example.food.dto.CustomerDTO;
import com.example.food.entity.CustomerEntity;
import com.example.food.mapper.CustomerMapper;
import com.example.food.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    CustomerMapper customerMapper;

    public List<CustomerDTO> getAllCustomer(){
        List<CustomerEntity> customerEntities = customerRepository.findAll();
        return customerEntities.stream()
                .map(customerMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<CustomerDTO> findCustomerByFirstName(String firstaName){
        List<CustomerEntity> customerEntity = customerRepository.findAllByfirstName(firstaName);
        return customerEntity.stream()
                .map(customerMapper::toDTO)
                .collect(Collectors.toList());
    }
}

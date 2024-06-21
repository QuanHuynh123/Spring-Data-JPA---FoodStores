package com.example.food.service;

import com.example.food.dto.CustomerDTO;
import com.example.food.entity.CustomerEntity;
import com.example.food.entity.OrdersEntity;
import com.example.food.enums.AppException;
import com.example.food.enums.ErrorCode;
import com.example.food.mapper.CustomerMapper;
import com.example.food.repository.CustomerRepository;
import lombok.NonNull;
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

    public CustomerDTO findCustomerById(String idCustomer){
        Optional<CustomerEntity> customerEntity = customerRepository.findById(idCustomer);
        return customerEntity.map(customerMapper::toDTO).orElse(null); // không có thì k map , cho null
    }

    public CustomerDTO addCustomer(CustomerDTO customerDTO){
        CustomerEntity customerEntity = customerMapper.toEntity(customerDTO);
        CustomerEntity savedEntity= customerRepository.save(customerEntity);
        return customerMapper.toDTO(savedEntity);
    }

    public CustomerDTO updateCustomer(CustomerDTO customerDTO){
        CustomerEntity customerEntity = (customerRepository.findById(String.valueOf(customerDTO.getId()))
                .orElseThrow(() -> new AppException(ErrorCode.CUSTOMER_NOT_FOUND)));

        CustomerEntity customerEntityUpdate = customerMapper.toEntity(customerDTO);
        customerEntityUpdate.setOrders(customerEntity.getOrders());

        CustomerEntity savedEntity= customerRepository.save(customerEntityUpdate);
        return customerMapper.toDTO(savedEntity);
    }

    public boolean checkCustomerExists(String idCustomer) {
        return customerRepository.existsById(idCustomer);
    }

    public String deleteCustomer(String idCustomer){
        if(!checkCustomerExists(idCustomer)) {
            throw new AppException(ErrorCode.CUSTOMER_NOT_FOUND);
        }

        customerRepository.deleteById(idCustomer);
        return "Deleted customer";
    }
}

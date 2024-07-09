package com.example.food.service;

import com.example.food.dto.OrdersCountDTO;
import com.example.food.dto.OrdersDTO;
import com.example.food.entity.OrdersEntity;
import com.example.food.enums.AppException;
import com.example.food.mapper.OrdersMapper;
import com.example.food.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrdersService {
    @Autowired
    OrdersRepository ordersRepository;
    @Autowired
    OrdersMapper ordersMapper ;

    public List<OrdersDTO> getAllOrder(){
        List<OrdersEntity> ordersEntities = ordersRepository.findAll();
        return ordersEntities.stream()
                .map(ordersMapper::toDTO)
                .collect(Collectors.toList());
    }

    public  List<OrdersDTO> getOrderByCustomerId(Integer id){
        List<OrdersEntity> ordersEntities = ordersRepository.findOrdersByCustomerId(id);
        return ordersEntities.stream()
                .map(ordersMapper::toDTO)
                .collect(Collectors.toList());
    }

    public  List<OrdersDTO> getOrderByPhone(String phone){
        List<OrdersEntity> ordersEntities = ordersRepository.findOrdersByCustomerPhone(phone);
        return ordersEntities.stream()
                .map(ordersMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<OrdersDTO> getAllOrdersOrderByDateAsc(){
        List<OrdersEntity> ordersEntities = ordersRepository.getAllOrdersOrderByDateAsc();
        return ordersEntities.stream()
                .map(ordersMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<OrdersDTO> getAllOrdersOrderByDateDesc(){
        List<OrdersEntity> ordersEntities = ordersRepository.getAllOrdersOrderByDateDesc();
        return ordersEntities.stream()
                .map(ordersMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<OrdersCountDTO> countOrdersInLastThreeMonths() {
        LocalDateTime threeMonthsAgo = LocalDateTime.now().minusMonths(3).withDayOfMonth(1).toLocalDate().atStartOfDay();
        return ordersRepository.countOrdersInLastThreeMonths(threeMonthsAgo);
    }
}

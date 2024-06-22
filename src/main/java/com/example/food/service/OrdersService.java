package com.example.food.service;

import com.example.food.dto.OrdersDTO;
import com.example.food.entity.OrdersEntity;
import com.example.food.enums.AppException;
import com.example.food.enums.ErrorCode;
import com.example.food.mapper.OrdersMapper;
import com.example.food.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrdersService {
    @Autowired
    OrdersRepository ordersRepository;
    @Autowired
    OrdersMapper ordersMapper;

    public OrdersDTO createNewOrder(OrdersDTO ordersDTO) {
        OrdersEntity ordersEntity = ordersMapper.toEntity(ordersDTO);
        return ordersMapper.toDTO(ordersRepository.save(ordersEntity));
    }

    public OrdersDTO getOrderById(Integer id) {
        OrdersEntity foundOrder = ordersRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.ORDER_NOT_FOUND));
        return ordersMapper.toDTO(foundOrder);
    }

    public List<OrdersDTO> getAllOrder() {
        List<OrdersEntity> ordersEntities = ordersRepository.findAll();
        return ordersEntities.stream()
                .map(ordersMapper::toDTO)
                .collect(Collectors.toList());
    }

    public void deleteOrder() {

    }
}

package com.example.food.service;

import com.example.food.dto.OrderItemDTO;
import com.example.food.entity.OrderItemEntity;
import com.example.food.mapper.OrderItemMapper;
import com.example.food.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderItemService {
    @Autowired
    OrderItemRepository orderItemRepository;
    @Autowired
    OrderItemMapper orderItemMapper;
    public List<OrderItemDTO> getALlOrderItem(){
        List<OrderItemEntity> orderItemEntities = orderItemRepository.findAll();
        return orderItemEntities.stream()
                .map(orderItemMapper::toDTO)
                .collect(Collectors.toList());
    }

}

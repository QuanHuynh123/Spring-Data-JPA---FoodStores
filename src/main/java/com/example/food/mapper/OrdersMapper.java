package com.example.food.mapper;

import com.example.food.dto.OrdersDTO;
import com.example.food.dto.ProductDTO;
import com.example.food.entity.OrdersEntity;
import com.example.food.entity.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface OrdersMapper {
    OrdersDTO toDTO(OrdersEntity ordersEntity);

    OrdersEntity toEntity(OrdersDTO ordersDTO);


}

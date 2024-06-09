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
    @Mappings({// Ánh xạ id
            @Mapping(source = "customer.id", target = "customerId")
    })
    OrdersDTO toDTO(OrdersEntity ordersEntity);

    @Mappings({
            @Mapping(source = "customerId", target = "customer.id")
    })
    OrdersEntity toEntity(OrdersDTO ordersDTO);
}

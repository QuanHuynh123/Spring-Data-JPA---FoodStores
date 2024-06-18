package com.example.food.mapper;

import com.example.food.dto.OrderItemDTO;
import com.example.food.dto.OrdersDTO;
import com.example.food.entity.OrderItemEntity;
import com.example.food.entity.OrdersEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface OrderItemMapper {
//    @Mappings({// Ánh xạ id
//            @Mapping(source = "product.id", target = "productId"),
//            @Mapping(source = "order.id", target = "orderId")
//    })
    OrderItemDTO toDTO(OrderItemEntity orderItemEntity);

//    @Mappings({
//            @Mapping(source = "productId", target = "product.id"),
//            @Mapping(source = "orderId", target = "order.id")
//    })
    OrderItemEntity toEntity(OrderItemDTO orderItemDTO);
}

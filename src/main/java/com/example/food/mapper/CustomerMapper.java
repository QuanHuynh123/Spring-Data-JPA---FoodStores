package com.example.food.mapper;

import com.example.food.dto.CustomerDTO;
import com.example.food.entity.CustomerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    //Các thuộc tính trùng tên thì không cần phải map

    CustomerDTO toDTO(CustomerEntity customerEntity);

    CustomerEntity toEntity(CustomerDTO customerDTO);
}

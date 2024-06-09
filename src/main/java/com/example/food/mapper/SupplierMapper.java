package com.example.food.mapper;

import com.example.food.dto.SupplierDTO;
import com.example.food.entity.SupplierEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SupplierMapper {

    SupplierDTO toDTO(SupplierEntity supplierEntity);
    SupplierEntity toEntity(SupplierDTO supplierDTO);
}

package com.example.food.mapper;

import com.example.food.dto.SupplierDTO;
import com.example.food.entity.SupplierEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface SupplierMapper {

    void update(@MappingTarget SupplierEntity entity, SupplierDTO dto);

    SupplierDTO toDTO(SupplierEntity supplierEntity);
    SupplierEntity toEntity(SupplierDTO supplierDTO);
}

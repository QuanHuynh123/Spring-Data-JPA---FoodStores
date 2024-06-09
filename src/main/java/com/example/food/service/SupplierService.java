package com.example.food.service;

import com.example.food.dto.SupplierDTO;
import com.example.food.entity.SupplierEntity;
import com.example.food.mapper.SupplierMapper;
import com.example.food.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SupplierService {
    @Autowired
    SupplierRepository supplierRepository;
    @Autowired
    SupplierMapper supplierMapper;

    List<SupplierDTO> getAllSupplier(){
        List<SupplierEntity> supplierEntities = supplierRepository.findAll();
        return supplierEntities.stream()
                .map(supplierMapper::toDTO)
                .collect(Collectors.toList());
    }

    List<SupplierDTO> findSupplierBycontactName(String contactName){
        List<SupplierEntity> supplierEntities = supplierRepository.findBycontactName(contactName);
        return supplierEntities.stream()
                .map(supplierMapper::toDTO)
                .collect(Collectors.toList());
    }

    public boolean deleteSupplier(Integer idSupplier){
        if (supplierRepository.existsById(idSupplier)) {
            supplierRepository.deleteById(idSupplier);
            return true;
        }else return false;
    }

    public SupplierDTO addSupplier(SupplierDTO supplierDTO){
        SupplierEntity supplierEntity = supplierMapper.toEntity(supplierDTO);
        return supplierMapper.toDTO(supplierRepository.save(supplierEntity));
    }
}

package com.example.food.service;

import com.example.food.dto.SupplierDTO;
import com.example.food.entity.SupplierEntity;
import com.example.food.enums.AppException;
import com.example.food.enums.ErrorCode;
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

    public SupplierDTO addSupplier(SupplierDTO supplierDTO){
        if(supplierRepository.existsById(supplierDTO.getId())) throw new AppException(ErrorCode.SUPPLIER_EXISTED);
        SupplierEntity supplierEntity = supplierMapper.toEntity(supplierDTO);
        return supplierMapper.toDTO(supplierRepository.save(supplierEntity));
    }

    public List<SupplierDTO> getAllSupplier(){
        List<SupplierEntity> supplierEntities = supplierRepository.findAll();
        return supplierEntities.stream()
                .map(supplierMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<SupplierDTO> findSupplierByContactName(String contactName){
        List<SupplierEntity> supplierEntities = supplierRepository.findBycontactName(contactName);
        return supplierEntities.stream()
                .map(supplierMapper::toDTO)
                .collect(Collectors.toList());
    }

    public SupplierDTO findSupplierById(int id){
        return supplierMapper.toDTO(supplierRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.SUPPLIER_NOT_FOUND)));
    }

    public SupplierDTO updateSupplier(int id, SupplierDTO supplierDTO){
        SupplierEntity entity = supplierRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.SUPPLIER_NOT_FOUND));

        supplierMapper.update(entity, supplierDTO);
        return supplierMapper.toDTO(supplierRepository.save(entity));
    }

    public void deleteSupplier(Integer idSupplier){
        supplierRepository.deleteById(idSupplier);
    }

}

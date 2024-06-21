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

    public List<SupplierDTO> getAllSupplier() {
        List<SupplierEntity> supplierEntities = supplierRepository.findAll();
        return supplierEntities.stream()
                .map(supplierMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<SupplierDTO> getSupplierByContactName(String contactName) {
        List<SupplierEntity> supplierEntities = supplierRepository.findBycontactName(contactName);
        if(supplierEntities.isEmpty()) {
            throw new AppException(ErrorCode.SUPPLIER_NOT_FOUND);
        }

        return supplierEntities.stream()
                .map(supplierMapper::toDTO)
                .collect(Collectors.toList());
    }

    public SupplierDTO getSupplierById(Integer id) {
        SupplierEntity foundSupplier = supplierRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.SUPPLIER_NOT_FOUND));
        return supplierMapper.toDTO(foundSupplier);
    }

    public void deleteSupplier(Integer idSupplier) {
        SupplierEntity foundSupplier = supplierRepository.findById(idSupplier)
                .orElseThrow(() -> new AppException(ErrorCode.SUPPLIER_NOT_FOUND));
        supplierRepository.delete(foundSupplier);
    }

    public SupplierDTO updateSupplier(Integer id, SupplierDTO update) {
        SupplierEntity foundSupplier = supplierRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.SUPPLIER_NOT_FOUND));

        supplierMapper.update(foundSupplier, update);

        return supplierMapper.toDTO(supplierRepository.save(foundSupplier));
    }

    public SupplierDTO addSupplier(SupplierDTO supplierDTO) {
        SupplierEntity supplierEntity = supplierMapper.toEntity(supplierDTO);
        return supplierMapper.toDTO(supplierRepository.save(supplierEntity));
    }
}

package com.example.food.service;

import com.example.food.dto.ProductDTO;
import com.example.food.entity.ProductEntity;
import com.example.food.entity.SupplierEntity;
import com.example.food.enums.AppException;
import com.example.food.mapper.ProductMapper;
import com.example.food.repository.ProductRepository;
import com.example.food.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    SupplierRepository supplierRepository;
    @Autowired
    ProductMapper productMapper;

    public List<ProductDTO> getAllProduct(){
        List<ProductEntity> productEntities =  productRepository.findAll();
        return productEntities.stream()
                .map(productMapper::toDTO)
                .collect(Collectors.toList());
    }
    public ProductDTO getOneProduct(int idProduct){
        ProductEntity productEntity =  productRepository
                .findById(idProduct).orElseThrow(() -> new AppException());
        return productMapper.toDTO(productEntity);
    }

    public ProductDTO saveProduct(ProductDTO productDTO){
        SupplierEntity supplierEntity = supplierRepository
                .findById(productDTO.getSupplierId()).orElseThrow(RuntimeException::new);

        ProductEntity productEntity = productMapper.toEntity(productDTO);
        productEntity.setSupplier(supplierEntity);
        ProductEntity saveEntity = productRepository.save(productEntity);
        return productMapper.toDTO(saveEntity);
    }

    public void deleteProduct(int idProduct){
        productRepository.deleteById(idProduct);
    }
}

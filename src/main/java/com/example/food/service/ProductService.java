package com.example.food.service;

import com.example.food.dto.ProductDTO;
import com.example.food.entity.ProductEntity;
import com.example.food.entity.SupplierEntity;
import com.example.food.mapper.ProductMapper;
import com.example.food.repository.ProductRepository;
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
    SupplierEntity supplierEntity;
    @Autowired
    ProductMapper productMapper;

    public List<ProductDTO> getAllProduct(){
        List<ProductEntity> productEntities =  productRepository.findAll();
        return productEntities.stream()
                .map(productMapper::toDTO)
                .collect(Collectors.toList());
    }
    public Optional<ProductDTO> getOneProduct(int idProduct){
        Optional<ProductEntity> productEntity =  productRepository.findById(idProduct);
        return productEntity.map(productMapper::toDTO);
    }

    public ProductDTO saveProduct(ProductDTO productDTO){
        ProductEntity productEntity = productMapper.toEntity(productDTO);
        ProductEntity saveEntity = productRepository.save(productEntity);
        return productMapper.toDTO(saveEntity);
    }

    public void saveProduct(int idProduct){
        productRepository.deleteById(idProduct);
    }
}

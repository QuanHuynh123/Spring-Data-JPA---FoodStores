package com.example.food.service;

import com.example.food.entity.ProductEntity;
import com.example.food.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<ProductEntity> getAllProduct(){
        return productRepository.findAll();
    }
    public Optional<ProductEntity> getOneProduct(int idProduct){return  productRepository.findById(idProduct);}

    public ProductEntity saveProduct(ProductEntity productEntity){
        return  productRepository.save(productEntity);
    }

    public void saveProduct(int idProduct){
        productRepository.deleteById(idProduct);
    }
}

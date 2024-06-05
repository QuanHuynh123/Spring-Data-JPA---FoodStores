package com.example.food.controller;

import com.example.food.entity.ProductEntity;
import com.example.food.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/getAllProduct")
    public List<ProductEntity> getAllProduct(){
        return productService.getAllProduct();
    }

    @GetMapping("/getOneProduct/{idProduct}")
    public Optional<ProductEntity> getOneProduct(@PathVariable int idProduct){
        return productService.getOneProduct(idProduct);
    }

    // 2 cách như nhau
//    @GetMapping("/getOneProduct")
//    public Optional<ProductEntity> getOneProduct(int idProduct){
//        return productService.getOneProduct(idProduct);
//    }
    @PostMapping("/addProduct")
    public ProductEntity saveProduct( ProductEntity productEntity){
        return productService.saveProduct(productEntity);
    }

    @DeleteMapping("/deleteProduct/{idProduct}")
    public ProductEntity deleteProduct( ProductEntity productEntity){
        return productService.saveProduct(productEntity);
    }

}

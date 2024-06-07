package com.example.food.controller;

import com.example.food.dto.ProductDTO;
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
    public List<ProductDTO> getAllProduct(){
        return productService.getAllProduct();
    }

    @GetMapping("/findOneProduct/{idProduct}")
    public Optional<ProductDTO> getOneProduct(@PathVariable int idProduct){
        return productService.getOneProduct(idProduct);
    }

    // 2 cách như nhau
//    @GetMapping("/getOneProduct")
//    public Optional<ProductEntity> getOneProduct(int idProduct){
//        return productService.getOneProduct(idProduct);
//    }
    @PostMapping("/addProduct")
    public ProductDTO saveProduct( ProductDTO productDTO){
        return productService.saveProduct(productDTO);
    }

    @DeleteMapping("/deleteProduct/{idProduct}")
    public ProductDTO deleteProduct(@PathVariable ProductDTO productEntity){
        return productService.saveProduct(productEntity);
    }

}

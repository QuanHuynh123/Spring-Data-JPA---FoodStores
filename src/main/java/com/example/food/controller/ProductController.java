package com.example.food.controller;

import com.example.food.dto.ApiResponse;
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
    public ApiResponse<List<ProductDTO>> getAllProduct(){
        return ApiResponse.<List<ProductDTO>>builder()
                .result(productService.getAllProduct())
                .build();
    }

    // add handling exception
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
    public ApiResponse<ProductDTO> saveProduct( ProductDTO productDTO){
        return ApiResponse.<ProductDTO>builder()
                .result(productService.saveProduct(productDTO))
                .build();
    }

    @DeleteMapping("/deleteProduct/{idProduct}")
    public ApiResponse<String> deleteProduct(@PathVariable int idProduct){
        productService.deleteProduct(idProduct);
        return ApiResponse.<String>builder().result("Product Deleted").build();
    }

}

package com.example.food.controller;

import com.example.food.dto.ApiResponse;
import com.example.food.dto.SupplierDTO;
import com.example.food.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SupplierController {
    @Autowired
    SupplierService supplierService;

    @PostMapping("/suppliers")
    public ApiResponse<SupplierDTO> createSupplier(@RequestBody SupplierDTO supplier) {
        return ApiResponse.<SupplierDTO>builder()
                .result(supplierService.addSupplier(supplier))
                .build();
    }

    @GetMapping("/suppliers")
    public ApiResponse<List<SupplierDTO>> getAllSuppliers() {
        return ApiResponse.<List<SupplierDTO>>builder()
                .result(supplierService.getAllSupplier())
                .build();
    }

    @GetMapping("/suppliersById/{id}")
    public ApiResponse<SupplierDTO> getSupplierById(@PathVariable int id) {
        return ApiResponse.<SupplierDTO>builder()
                .result(supplierService.findSupplierById(id))
                .build();
    }

    @GetMapping("/suppliersByName/{name}")
    public ApiResponse<List<SupplierDTO>> getSupplierByName(@PathVariable String name) {
        return ApiResponse.<List<SupplierDTO>>builder()
                .result(supplierService.findSupplierByContactName(name))
                .build();
    }

    @PutMapping ("/suppliers/{id}")
    public ApiResponse<SupplierDTO> updateSupplier(@PathVariable int id, @RequestBody SupplierDTO supplier) {
        return ApiResponse.<SupplierDTO>builder()
                .result(supplierService.updateSupplier(id, supplier))
                .build();
    }

    @DeleteMapping("/suppliers/{id}")
    public ApiResponse<String> deleteSupplier(@PathVariable int id) {
        supplierService.deleteSupplier(id);
        return ApiResponse.<String>builder().result("Supplier Deleted").build();
    }

}

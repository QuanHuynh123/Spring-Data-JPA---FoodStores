package com.example.food.controller;

import com.example.food.dto.ApiResponse;
import com.example.food.dto.SupplierDTO;
import com.example.food.service.SupplierService;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/suppliers")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class SupplierController {

    @Autowired
    SupplierService supplierService;

    @PostMapping
    public ApiResponse<SupplierDTO> addNewSupplier(@RequestBody SupplierDTO supplier) {
        return ApiResponse.<SupplierDTO>builder()
                .result(supplierService.addSupplier(supplier))
                .build();
    }

    @GetMapping
    public ApiResponse<List<SupplierDTO>> getAllSupplier() {
        return ApiResponse.<List<SupplierDTO>>builder()
                .result(supplierService.getAllSupplier())
                .build();
    }

    @GetMapping("/contactName/{contactName}")
    public ApiResponse<List<SupplierDTO>> getByContactName(@PathVariable String contactName){
        return ApiResponse.<List<SupplierDTO>>builder()
                .result(supplierService.getSupplierByContactName(contactName))
                .build();
    }

    @GetMapping("/{id}")
    public ApiResponse<SupplierDTO> getById(@PathVariable Integer id){
        return ApiResponse.<SupplierDTO>builder()
                .result(supplierService.getSupplierById(id))
                .build();
    }

    @PutMapping("/{id}")
    public ApiResponse<SupplierDTO> updateSupplier(@PathVariable Integer id, @RequestBody SupplierDTO update) {
        return ApiResponse.<SupplierDTO>builder()
                .result(supplierService.updateSupplier(id, update))
                .build();
    }


    @DeleteMapping("/{id}")
    public ApiResponse<String> deleteSupplier(@PathVariable Integer id) {
        supplierService.deleteSupplier(id);
        return ApiResponse.<String>builder()
                .result("Supplier deleted")
                .build();
    }
}

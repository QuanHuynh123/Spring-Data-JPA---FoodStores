package com.example.food.repository;

import com.example.food.entity.SupplierEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SupplierRepository extends JpaRepository<SupplierEntity,Integer> {

    @Override
    List<SupplierEntity> findAll();

    @Override
    Optional<SupplierEntity> findById(Integer idSupplier);
}

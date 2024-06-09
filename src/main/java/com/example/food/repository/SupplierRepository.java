package com.example.food.repository;

import com.example.food.entity.SupplierEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SupplierRepository extends JpaRepository<SupplierEntity,Integer> {

    @Override
    boolean existsById(Integer idSupplier);

    @Override
    List<SupplierEntity> findAll();

    @Override
    Optional<SupplierEntity> findById(Integer idSupplier);

    @Override
    <S extends SupplierEntity> S save(S entity);

    @Override
    void deleteById(Integer integer);

    List<SupplierEntity> findBycontactName(String contactName);

}

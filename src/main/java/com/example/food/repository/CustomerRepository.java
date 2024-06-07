package com.example.food.repository;

import com.example.food.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity,String> {

    @Override
    List<CustomerEntity> findAll();

    // Phụ thuộc vào việc tên biến sau "By" khớp với biến Entity
    List<CustomerEntity> findAllByfirstName(String firstName);
}

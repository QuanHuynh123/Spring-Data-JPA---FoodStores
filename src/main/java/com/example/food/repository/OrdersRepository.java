package com.example.food.repository;

import com.example.food.entity.OrdersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersRepository extends JpaRepository<OrdersEntity,Integer> {
    @Override
    List<OrdersEntity> findAll();

    
}

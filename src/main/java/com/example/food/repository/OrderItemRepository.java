package com.example.food.repository;

import com.example.food.entity.OrderItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItemEntity,Integer> {
    @Override
    List<OrderItemEntity> findAll();
}

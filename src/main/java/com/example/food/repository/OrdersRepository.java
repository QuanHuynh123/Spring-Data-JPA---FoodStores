package com.example.food.repository;

import com.example.food.entity.OrdersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrdersRepository extends JpaRepository<OrdersEntity,Integer> {
    @Override
    List<OrdersEntity> findAll();
    Optional<OrdersEntity> findByCustomerId(Integer integer);
}

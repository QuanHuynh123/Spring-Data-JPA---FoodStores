package com.example.food.repository;

import com.example.food.dto.OrdersCountDTO;
import com.example.food.entity.OrdersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface OrdersRepository extends JpaRepository<OrdersEntity,Integer> {
    @Override
    List<OrdersEntity> findAll();
    @Override
    boolean existsById(Integer idOrder);

    @Query("SELECT o FROM OrdersEntity o JOIN o.customer c WHERE c.phone = :phone")
    List<OrdersEntity> findOrdersByCustomerPhone(@Param("phone") String phone);

    @Query("SELECT o FROM OrdersEntity o JOIN o.customer c WHERE c.id = :customerId")
    List<OrdersEntity> findOrdersByCustomerId(@Param("customerId") Integer customerId);

    // Lấy tất cả đơn hàng và sắp xếp theo ngày cũ đến mới
    @Query("SELECT o FROM OrdersEntity o ORDER BY o.orderDate ASC")
    List<OrdersEntity> getAllOrdersOrderByDateAsc();

    // Lấy tất cả đơn hàng và sắp xếp theo ngày mới đến cũ
    @Query("SELECT o FROM OrdersEntity o ORDER BY o.orderDate DESC")
    List<OrdersEntity> getAllOrdersOrderByDateDesc();

    @Query("SELECT new com.example.food.dto.OrdersCountDTO(MONTH(o.orderDate), COUNT(o)) " +
            "FROM OrdersEntity o " +
            "WHERE o.orderDate >= :threeMonthsAgo " +
            "GROUP BY MONTH(o.orderDate) " +
            "ORDER BY MONTH(o.orderDate)")
    List<OrdersCountDTO> countOrdersInLastThreeMonths(@Param("threeMonthsAgo") LocalDateTime threeMonthsAgo);
}

package com.lovedeep.ecommerce.order_service.repository;

import com.lovedeep.ecommerce.order_service.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    // JpaRepository automatically provides methods like save(), findById(), and findAll()
}

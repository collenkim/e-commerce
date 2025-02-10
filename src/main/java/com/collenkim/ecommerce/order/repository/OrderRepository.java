package com.collenkim.ecommerce.order.repository;

import com.collenkim.ecommerce.order.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}

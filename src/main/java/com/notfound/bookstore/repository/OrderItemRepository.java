package com.notfound.bookstore.repository;

import com.notfound.bookstore.model.entity.Order;
import com.notfound.bookstore.model.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, UUID> {
    List<OrderItem> findByOrder(Order order);
    List<OrderItem> findByOrderId(UUID orderId);
}

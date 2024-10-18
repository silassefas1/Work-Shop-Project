package com.silassefas.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.silassefas.course.entities.OrderItem;
import com.silassefas.course.entities.pk.OrderItemPK;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {
	
}

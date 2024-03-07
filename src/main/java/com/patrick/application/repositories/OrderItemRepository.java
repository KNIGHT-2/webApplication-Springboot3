package com.patrick.application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.patrick.application.entities.OrderItem;
import com.patrick.application.entities.pk.OrderItemPK;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK>{

}

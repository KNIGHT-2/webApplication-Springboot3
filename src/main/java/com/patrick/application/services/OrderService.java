package com.patrick.application.services;

import com.patrick.application.entities.Order;
import com.patrick.application.entities.User;
import com.patrick.application.repositories.OrderRepository;
import com.patrick.application.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service//Registrando a classe como um "service"
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public List<Order> findAll(){
        return orderRepository.findAll();
    }

    public Optional<Order> findById(Long id){
        return orderRepository.findById(id);
    }
}

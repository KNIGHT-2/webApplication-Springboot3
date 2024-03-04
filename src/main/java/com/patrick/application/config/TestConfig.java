package com.patrick.application.config;

import com.patrick.application.entities.Order;
import com.patrick.application.entities.User;
import com.patrick.application.entities.enums.OrderStatus;
import com.patrick.application.repositories.OrderRepository;
import com.patrick.application.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    //Fazendo o Spring associar a instância do UserRepository na classe TestConfig
    @Autowired
    private UserRepository userRepository;//Injetando uma dependência do UserRepository
    @Autowired
    private OrderRepository orderRepository;
    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "Maria Brown", "maria@email.com", "9999999", "123456");
        User u2 = new User(null, "Alex Green", "alex@email.com", "88888888", "654321");

        userRepository.saveAll(Arrays.asList(u1, u2));

        Order o1 = new Order(null, Instant.parse("2024-01-12T20:53:30Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.parse("2024-02-27T13:42:12Z"), OrderStatus.WAITING_PAYMENT, u2);
        Order o3 = new Order(null, Instant.parse("2024-02-03T07:21:47Z"), OrderStatus.WAITING_PAYMENT, u1);

        orderRepository.saveAll(Arrays.asList(o1, o2, o3));

    }
}

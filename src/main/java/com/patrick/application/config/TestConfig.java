package com.patrick.application.config;

import com.patrick.application.entities.User;
import com.patrick.application.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    //Fazendo o Spring associar a instância do UserRepository na classe TestConfig
    @Autowired
    private UserRepository userRepository;//Injetando uma dependência do UserRepository

    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "Maria Brown", "maria@email.com", "9999999", "123456");
        User u2 = new User(null, "Alex Green", "alex@email.com", "88888888", "654321");

        userRepository.saveAll(Arrays.asList(u1, u2));
    }
}

package com.patrick.application.services;

import com.patrick.application.entities.Product;
import com.patrick.application.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository repository;

    public List<Product> findAll(){
        return repository.findAll();
    }

    public Optional<Product> findById(Long id){
        return repository.findById(id);
    }
}

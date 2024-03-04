package com.patrick.application.resources;

import com.patrick.application.entities.Category;
import com.patrick.application.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

    @Autowired
    private CategoryService service;

    @GetMapping
    ResponseEntity<List<Category>> findAll(){
        List<Category> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    ResponseEntity<Category> findById(@PathVariable long id){
        Category obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}

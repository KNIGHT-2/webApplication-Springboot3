package com.patrick.application.resources;

import com.patrick.application.entities.User;
import com.patrick.application.repositories.UserRepository;
import com.patrick.application.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //Dizendo que a classe será um controlador
@RequestMapping(value = "/users")//dando o nome que será utilizado na requisição
public class UserResource {

    @Autowired
    UserService service;

    @GetMapping//Dizendo que esse será o método responsável pelas requisições GET
    public ResponseEntity<List<User>> findAll(){
        List<User> list = service.findAll();
        return ResponseEntity.ok().body(list);//Fazendo o "obj" ser retornado como corpo da requisição
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById (@PathVariable Long id){

        User obj = service.findById(id).orElseThrow(() -> new RuntimeException());
        return ResponseEntity.ok().body(obj);
    }
}

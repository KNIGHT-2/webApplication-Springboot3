package com.patrick.application.resources;

import com.patrick.application.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //Dizendo que a classe será um controlador
@RequestMapping(value = "/users")//dando o nome que será utilizado na requisição
public class UserResource {

    @GetMapping//Dizendo que esse será o método responsável pelas requisições GET
    public ResponseEntity<User> findAll(){
        User obj = new User(1L, "Cleiton", "cleiton@email.com", "999999", "123");
        return ResponseEntity.ok().body(obj);//Fazendo o "obj" ser retornado como corpo da requisição
    }

}

package com.patrick.application.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.patrick.application.entities.User;
import com.patrick.application.services.UserService;



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

        User obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
    
    @PostMapping //Configurando para uma requisição "post"
    public ResponseEntity<User> insert(@RequestBody User obj) { 
        obj = service.insert(obj);
        //return ResponseEntity.ok().body(obj); Funciona, porém a reposta da requisição é a padrão (200OK)
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }
    
    @DeleteMapping(value = "{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
    	service.delete(id);
    	return ResponseEntity.noContent().build();
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj) {
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }
}

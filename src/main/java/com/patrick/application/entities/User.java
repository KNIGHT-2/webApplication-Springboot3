package com.patrick.application.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity //Especificando que essa classe será uma entidade
@Table(name = "tb_user") //Renomeando a tabela, pois "user" é uma palavra reservada pelo banco de dados H2
public class User implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id//dizendo que será a chave primário
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Dizendo que será gerada automaticamente, e com auto incremento
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String password;

    @OneToMany(mappedBy = "client")//passando o nome do atributo que está do outro lado da relação
    List<Order> orders = new ArrayList<>();

    public User(){}

    public User(Long id, String name, String email, String phone, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @JsonIgnore//Faz com que as informações da associação sejam buscadas apenas quando forem requisitadas
    public List<Order> getOrders(){
        return  orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

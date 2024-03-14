package com.patrick.application.services;

import com.patrick.application.entities.User;
import com.patrick.application.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service//Registrando a classe como um "service"
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public Optional<User> findById(Long id){
        return userRepository.findById(id);
    }
    
    public User insert(User obj) {
    	return userRepository.save(obj);
    }
    
    public void delete(Long id) {
    	userRepository.deleteById(id);
    }
    
    public User update(Long id, User obj) {
    	User entity = userRepository.getReferenceById(id);
    	updateData(entity, obj);
    	return userRepository.save(entity);
    }

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
}

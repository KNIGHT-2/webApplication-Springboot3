package com.patrick.application.services;

import java.util.List;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.patrick.application.entities.User;
import com.patrick.application.repositories.UserRepository;
import com.patrick.application.services.exceptions.DatabaseException;
import com.patrick.application.services.exceptions.ResourceNotFoundException;

@Service//Registrando a classe como um "service"
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(Long id){
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }
    
    public User insert(User obj) {
    	return userRepository.save(obj);
    }
    
    public void delete(Long id) {
    	try {
    		userRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
    	
    }
    
    public User update(Long id, User obj) {
    	try {
			User entity = userRepository.getReferenceById(id);
			updateData(entity, obj);
			return userRepository.save(entity);
		}catch (EntityNotFoundException e){
			throw new ResourceNotFoundException(id);
		}
    }

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
}

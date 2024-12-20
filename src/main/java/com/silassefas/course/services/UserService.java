package com.silassefas.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.silassefas.course.entities.User;
import com.silassefas.course.repositories.UserRepository;
import com.silassefas.course.services.exceptions.DatabaseException;
import com.silassefas.course.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service // registra a classe como serviço do spring, permitindo a injeção de dependencia
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id)) ;
	}
	
	public User insert(User object) {
		return repository.save(object); // a operação sava ja retorna o objeto salvo no banco
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
		
	}
	
	public User update(Long id, User object) {
		try {
			User entity = repository.getReferenceById(id);// instancia o usuario para ser monitorado pelo JPA
			updateData(entity, object);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(User entity, User object) {
		entity.setName(object.getName());
		entity.setEmail(object.getEmail());
		entity.setPhone(object.getPhone());
		
	}
}

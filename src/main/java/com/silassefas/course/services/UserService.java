package com.silassefas.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.silassefas.course.entities.User;
import com.silassefas.course.repositories.UserRepository;

@Service // registra a classe como serviço do spring, permitindo a injeção de dependencia
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}
	
	public User insert(User object) {
		return repository.save(object); // a operação sava ja retorna o objeto salvo no banco
	}
}

package com.silassefas.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.silassefas.course.entities.Order;
import com.silassefas.course.repositories.OrderRepository;

@Service // registra a classe como serviço do spring, permitindo a injeção de dependencia
public class OrderService {
	
	@Autowired
	private OrderRepository repository;
	
	public List<Order> findAll(){
		return repository.findAll();
	}
	
	public Order finById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get();
	}
}

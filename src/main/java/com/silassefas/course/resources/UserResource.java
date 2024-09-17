package com.silassefas.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.silassefas.course.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@GetMapping
	public ResponseEntity<User> findAll(){
		/*Apenas para teste*/
		User user = new User(1L, "Bod Marlei", "marlei@gmail.com", "9999999999", "1234567");
		return ResponseEntity.ok().body(user);
	}
}

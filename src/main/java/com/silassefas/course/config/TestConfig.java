package com.silassefas.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.silassefas.course.entities.User;
import com.silassefas.course.repositories.UserRepository;

@Configuration // indica para o spring que essa é uma classe de configuração
@Profile("test") // define o perfil para a classe de configuração
public class TestConfig implements CommandLineRunner{
	
	@Autowired //indica para o spring fazer a auto dependencia
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		
		User user1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User user2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		userRepository.saveAll(Arrays.asList(user1,user2));
	}
	
	
	
}

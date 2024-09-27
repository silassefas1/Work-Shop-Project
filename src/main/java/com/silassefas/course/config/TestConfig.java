package com.silassefas.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.silassefas.course.entities.Category;
import com.silassefas.course.entities.Order;
import com.silassefas.course.entities.User;
import com.silassefas.course.entities.enums.OrderStatus;
import com.silassefas.course.repositories.CategoryRepository;
import com.silassefas.course.repositories.OrderRepository;
import com.silassefas.course.repositories.UserRepository;

@Configuration // indica para o spring que essa é uma classe de configuração
@Profile("test") // define o perfil para a classe de configuração
public class TestConfig implements CommandLineRunner{
	
	@Autowired //indica para o spring fazer a auto dependencia
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public void run(String... args) throws Exception {
		
		User user1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User user2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		Order order1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, user1); 
		Order order2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, user2); 
		Order order3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, user1);
		
		Category category1 = new Category(null, "Electronics"); 
		Category category2 = new Category(null, "Books"); 
		Category category3 = new Category(null, "Computers"); 
		
		userRepository.saveAll(Arrays.asList(user1,user2));
		orderRepository.saveAll(Arrays.asList(order1, order2, order3));
		categoryRepository.saveAll(Arrays.asList(category1, category2, category3));
	}
	
	
	
}

package com.silassefas.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.silassefas.course.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}

package com.silassefas.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.silassefas.course.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}

package com.poly.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poly.entity.Categories;

public interface CategoryDAO extends JpaRepository<Categories, String>{
	
}

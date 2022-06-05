package com.example.mt.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mt.model.Products;

public interface ProductDao extends JpaRepository<Products, Integer>{

//	List<Products> findAllProducts();
	
}

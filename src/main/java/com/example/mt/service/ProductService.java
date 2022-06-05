package com.example.mt.service;

import java.util.List;
import java.util.Optional;

import com.example.mt.exception.IdDoesnotExist;
import com.example.mt.model.Products;

public interface ProductService {

	Products addProducts(Products products) throws IdDoesnotExist;

	List<Products> findAllProducts();

	Products UpdateProducts(Products products) throws IdDoesnotExist;

	Products findOneProduct(int id) throws IdDoesnotExist;

	Products DeleteProduct(int productId) throws IdDoesnotExist;
}

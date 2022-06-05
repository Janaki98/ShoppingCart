package com.example.mt.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mt.dao.ProductDao;
import com.example.mt.exception.IdDoesnotExist;
import com.example.mt.exception.ProductNotFoundException;
import com.example.mt.model.Products;

@Service
public class ProductServiceImpl implements ProductService{
	
	
	private final ProductDao productDao;
	
	@Autowired
	public ProductServiceImpl(ProductDao productDao) {
		this.productDao = productDao;
	}

	@Override
	public List<Products> findAllProducts() {
		
		return StreamSupport
				.stream(productDao.findAll().spliterator(), false)
				.collect(Collectors.toList());
	}

	@Override
	public Products addProducts(Products products) throws IdDoesnotExist {
//		products.get
//		System.out.println(products.getProductName()+" , "+products.getPrice());
		Products productSave = productDao.save(products);
//		productSave.get
		System.out.println(productSave.getProductName()+" , "+productSave.getPrice());
			return findOneProduct(productSave.getProductId());
		
	}

	@Override
	public Products UpdateProducts(Products products) throws IdDoesnotExist {
		Products existingProduct = findOneProduct(products.getProductId());
			System.out.println(existingProduct.getClass().toString());
//					if(existingProduct.getProductName()!=null) {
//						existingProduct.setProductName(products.getProductName());
//					}
//					else {
//						existingProduct.setPrice(products.getPrice());
//					}
			System.out.println(products.getClass().toString());
					BeanUtils.copyProperties(products, existingProduct);
					
					productDao.save(existingProduct);
					System.out.println(products.getClass().toString());
		return products;
	}

	@Override
	public Products findOneProduct(int id) throws IdDoesnotExist {
		return productDao.findById(id).orElseThrow(()->
			new IdDoesnotExist());
	}

	@Override
	public Products DeleteProduct(int productId) throws IdDoesnotExist {
		Products product = findOneProduct(productId);
		 productDao.delete(product);
		 return product;
	}

}

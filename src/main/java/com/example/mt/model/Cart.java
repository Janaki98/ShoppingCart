package com.example.mt.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

//@Data
@Entity
@Table(name = "cart")
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cartId;
	
	private int qty;
//	,mappedBy = "cart"  
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_cart_id")
	private List<Products> products = new ArrayList<>();

	public Cart() {
	}
	
//	public void addItem(Products product) {
//		products.add(product);
//	}
//	
//	public void removeItem(Products product) {
//		products.add(product);
//	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public List<Products> getProducts() {
		return products;
	}

	public void setProducts(List<Products> products) {
		this.products = products;
	}

	
	
}

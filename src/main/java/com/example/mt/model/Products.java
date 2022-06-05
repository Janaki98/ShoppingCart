package com.example.mt.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

//@Data
@Entity
@Table(name = "products")
public class Products {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int productId;
	private String productName;
	private float price;
	private int productQnty;

	@OneToOne(cascade = CascadeType.ALL)
	private Books books;

//	@ManyToOne
//    @JoinColumn(name="cart_id", nullable=true)
//    private Cart cart;
	
	public Products() {
	}

	public Products(int productId, String productName, float price, Books books) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.books = books;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Books getBooks() {
		return books;
	}

	public void setBooks(Books books) {
		this.books = books;
	}

	public int getProductQnty() {
		return productQnty;
	}

	public void setProductQnty(int productQnty) {
		this.productQnty = productQnty;
	}

}

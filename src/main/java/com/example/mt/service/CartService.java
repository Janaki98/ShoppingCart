package com.example.mt.service;

import java.util.List;

import com.example.mt.exception.IdDoesnotExist;
import com.example.mt.exception.ItemAlreadyAssignedException;
import com.example.mt.model.Cart;

public interface CartService {
	
	public List<Cart> getCarts();

	public Cart addCart(Cart cart);
	
	public Cart getcart(int id);
	
	public Cart deleteCart(int id);
	
//	public Cart editCart(int id, Cart cart);
	
	public Cart addProducttoCart(int id, int productId) throws ItemAlreadyAssignedException, IdDoesnotExist;

	public Cart removeItemfromCart(int cartId, int productId) throws IdDoesnotExist;


	public Cart addProducttoNewCart(int productId) throws IdDoesnotExist;

	public Cart editCart(int cartId, int productId, Cart cart);

//	public Cart addProducttoCart(int productId, Cart cart) throws IdDoesnotExist;

}

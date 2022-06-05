package com.example.mt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.mt.exception.IdDoesnotExist;
import com.example.mt.exception.ItemAlreadyAssignedException;
import com.example.mt.model.Cart;
import com.example.mt.service.CartService;

@RestController
@RequestMapping(value = "/cart")
public class CartController {

	private final CartService cartService;

	@Autowired
	public CartController(CartService cartService) {
		this.cartService = cartService;
	}

	@RequestMapping(value = { "/getCarts" }, method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Cart>> CartView() {
		return new ResponseEntity<>(cartService.getCarts(), HttpStatus.OK);
	}

	@RequestMapping(value = { "/getCart/{id}" }, method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Cart> CartViewbyId(@PathVariable("id") int id) {
		return new ResponseEntity<>(cartService.getcart(id), HttpStatus.OK);
	}

	@RequestMapping(value = {
			"/add" }, method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity<Cart> addCart(@RequestBody Cart cart) {

		return new ResponseEntity<>(cartService.addCart(cart), HttpStatus.OK);
	}

	@RequestMapping(value = {
			"/edit/{cartId}/{productId}" }, method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
	public ResponseEntity<Cart> updateCart(@PathVariable("cartId") int cartId, @PathVariable("productId") int productId, @RequestBody Cart cart) {

		return new ResponseEntity<>(cartService.editCart(cartId,productId, cart), HttpStatus.OK);
	}

	@RequestMapping(value = { "/delete/{id}" }, method = RequestMethod.POST)
	public ResponseEntity<Cart> cartDelete(@PathVariable("id") int id) {

		return new ResponseEntity<>(cartService.deleteCart(id), HttpStatus.OK);
	}

	@RequestMapping(value = { "/addToCart/{cartId}/{productId}" }, method = RequestMethod.POST)
	public ResponseEntity<Cart> addTocartbyId(@PathVariable("cartId") int id, @PathVariable("productId") int productId) throws IdDoesnotExist, ItemAlreadyAssignedException {

		return new ResponseEntity<>(cartService.addProducttoCart(id, productId), HttpStatus.OK);
	}
	
	@RequestMapping(value = { "/addToNewCart/{productId}" }, method = RequestMethod.POST)
	public ResponseEntity<Cart> addTocartbyId(@PathVariable("productId") int productId) throws IdDoesnotExist {

		return new ResponseEntity<>(cartService.addProducttoNewCart(productId), HttpStatus.OK);
	}

	@RequestMapping(value = { "/removeToCart/{id}/{productId}" }, method = RequestMethod.POST)
	public ResponseEntity<Cart> removeFromCart(@PathVariable("id") int id, @PathVariable("productId") int productId) throws IdDoesnotExist {

		return new ResponseEntity<>(cartService.removeItemfromCart(id, productId), HttpStatus.OK);
	}

}

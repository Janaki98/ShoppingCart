package com.example.mt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mt.dao.CartDao;
import com.example.mt.exception.CartNotFoundException;
import com.example.mt.exception.IdDoesnotExist;
import com.example.mt.exception.ItemAlreadyAssignedException;
import com.example.mt.model.Cart;
import com.example.mt.model.Products;

@Service
public class CartServiceImpl implements CartService {

	private final CartDao cartDao;
	private final ProductService productService;

	@Autowired
	public CartServiceImpl(CartDao cartDao, ProductService productService) {
		this.cartDao = cartDao;
		this.productService = productService;
	}

	@Override
	public Cart addCart(Cart cart) {

		Cart cartObj = new Cart();
		cartObj.setQty(cart.getQty());
		cartObj.setProducts(cart.getProducts());

		return cartDao.save(cart);

	}

	@Override
	public List<Cart> getCarts() {
		return StreamSupport.stream(cartDao.findAll().spliterator(), false).collect(Collectors.toList());
	}

	@Override
	public Cart getcart(int id) {
		return cartDao.findById(id).orElseThrow(() -> new CartNotFoundException(id));
	}

	@Override
	public Cart deleteCart(int id) {
		Cart cart = getcart(id);
		cartDao.delete(cart);
		return cart;
	}

	@Override
//	@Transactional
	public Cart editCart(int cartId, int ProductId, Cart cart) {
		Cart cartUpdate = getcart(cartId);
		cartUpdate.setProducts(cart.getProducts());
		return cartUpdate;
	}

	@Override
	public Cart addProducttoCart(int cartId, int productId) throws ItemAlreadyAssignedException, IdDoesnotExist {
		Cart cart = new Cart();
		List<Products> newProducList = new ArrayList<Products>();
		Products newProduct;
		List<Products> existingProductList = cartDao.findById(cartId).get().getProducts();
		
//		if (!cartDao.findById(cartId).isPresent()) {
////			throw new IdDoesnotExist("CartId doesn't exist");
//			
//			if(productId==existingProduct.getProductId()) {
//				int qnty = existingProductList.get(i).getProductQnty();
//				existingProduct.setProductQnty(qnty+1);
//				existingProduct.setPrice(addingProduct.getPrice()*addingProduct.getProductQnty());
//				newProducList.add(existingProduct);
//				cart.setProducts(newProducList);
//				cart.setQty(cartDao.findById(cartId).get().getQty() + 1);
////				
//				
//		} else {
//			newProduct = productService.findOneProduct(productId);
			List<Integer> ids = existingProductList.stream()
                    .map(Products::getProductId).collect(Collectors.toList());
////			Products existingProduct = new Products();
//			
//			
//			if (ids.contains(productId)) {				
//				throw new ItemAlreadyAssignedException();
//			}else {
//				newProducList = addItem(newProduct);
//				cart.setProducts(existingProductList);
//				cart.setProducts(newProducList);
////				newProducList.addAll(existingProductList);
////				cart.setProducts(newProducList);
//				cart.setQty(cartDao.findById(cartId).get().getQty() + 1);
//			}
		for (int i = 0; i < existingProductList.size();i++) 
			{
			cart.setCartId(cartId);
			Products existingProduct = productService.findOneProduct(existingProductList.get(i).getProductId());
			
			Products addingProduct = productService.findOneProduct(productId);
			
			if (ids.contains(productId)) {
				
				System.out.println("idssssssss"+ids);
				if(productId==existingProduct.getProductId()) {
					int qnty = existingProductList.get(i).getProductQnty();
					existingProduct.setProductQnty(qnty+1);
					existingProduct.setPrice(addingProduct.getPrice()*addingProduct.getProductQnty());
					newProducList.add(existingProduct);
					cart.setProducts(newProducList);
					cart.setQty(cartDao.findById(cartId).get().getQty() + 1);
					
				}
				}
			else {
//				newProducList = addItem(newProduct);
				cart.setProducts(existingProductList);
				cart.setProducts(newProducList);
				newProducList.add(existingProduct);
				cart.setQty(cartDao.findById(cartId).get().getQty() + 1);
			}
//			break;
		}

		
		
		return cartDao.save(cart);
	}

	@Override
	public Cart addProducttoNewCart(int productId) throws IdDoesnotExist {
		Cart cartobj = new Cart();
		Products product = productService.findOneProduct(productId);

		if (product != null) {
			product.setProductQnty(1);
			List<Products> products = addItem(product);
			cartobj.setProducts(products);
			cartobj.setQty(1);
		}
		return cartDao.save(cartobj);
	}

	public List<Products> addItem(Products product) {
		List<Products> products = new ArrayList<>();
		product.setProductQnty(1);
		products.add(product);
		return products;
	}

	@Override
//	@Transactional
	public Cart removeItemfromCart(int cartId, int productId) throws IdDoesnotExist {
		Cart cart = getcart(cartId);
		Products product = productService.findOneProduct(productId);
//		cart.removeItem(product);
		return cart;
	}

	public List<Products> removeItem(Products product) {
		List<Products> products = new ArrayList<>();
		products.add(product);
		return products;
	}
}

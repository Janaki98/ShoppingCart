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
import com.example.mt.model.Products;
import com.example.mt.service.ProductService;

@RestController
@RequestMapping(value = { "/products" })
public class ProductController {

	private final ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@RequestMapping(value = { "/view" }, method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Products>> productsView() {

		return new ResponseEntity<>(productService.findAllProducts(), HttpStatus.OK);
	}

	@RequestMapping(value = {
			"/view/{id}" }, method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
	public ResponseEntity<Products> productsAllView(@PathVariable("id") int productId) throws IdDoesnotExist {

		return new ResponseEntity<>(productService.findOneProduct(productId), HttpStatus.OK);
	}

	@RequestMapping(value = {
			"/add" }, method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity<Products> productsAdd(@RequestBody Products products) throws IdDoesnotExist {

		return new ResponseEntity<>(productService.addProducts(products), HttpStatus.OK);
	}

//	@RequestMapping(value = {
//			"/update" }, method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
//	public ResponseEntity<Products> productsUpdate(@RequestBody Products products) throws IdDoesnotExist {
//		return new ResponseEntity<>(productService.UpdateProducts(products), HttpStatus.OK);
//	}

//	   @RequestMapping(value = { "/delete/{id}" }, method = RequestMethod.POST)
//	   public String productsDelete(@PathVariable("id") int productId) throws IdDoesnotExist {
//		   
//	       productService.DeleteProduct(productId);
//	       
//	       return "deleted Successfully";
//	   }

}

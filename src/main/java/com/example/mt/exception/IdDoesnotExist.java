package com.example.mt.exception;

//@ControllerAdvice
//@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class IdDoesnotExist extends Exception {

	public IdDoesnotExist(String msg) {
		super(msg);
	}

	public IdDoesnotExist() {
	}

	private static final long serialVersionUID = 1L;

//	public IdDoesnotExist(Products products) {
//		super(MessageFormat.format("ProductId {0} doesn't exist!!!", products.getProductId()));
//
//	}

	
	
//	   @ExceptionHandler(value = ProductNotfoundException.class)
//	   public ResponseEntity<Object> exception(ProductNotfoundException exception) {
//	      return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
//	   }
}

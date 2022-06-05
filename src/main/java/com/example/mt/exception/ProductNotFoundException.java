package com.example.mt.exception;

import java.text.MessageFormat;

public class ProductNotFoundException extends RuntimeException{

	public ProductNotFoundException(final int id) {
		super(MessageFormat.format("could not find product with id : {0}", id));
	}
}

package com.example.mt.exception;

import java.text.MessageFormat;

public class CartNotFoundException extends RuntimeException {

	public CartNotFoundException(final int id) {
		super(MessageFormat.format("could not find cart with id : {0}", id));
	}
}

package com.example.mt.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@ResponseStatus
public class ExceptionController {

	@ExceptionHandler(value = IdDoesnotExist.class)
	public ResponseEntity<Object> exception(IdDoesnotExist exception) {
		return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = ItemAlreadyAssignedException.class)
	public ResponseEntity<Object> existingException(ItemAlreadyAssignedException exception) {
		return new ResponseEntity<>("Item already exists in cart", HttpStatus.BAD_REQUEST);
	}
}

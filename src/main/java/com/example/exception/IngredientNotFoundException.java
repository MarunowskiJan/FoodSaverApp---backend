package com.example.exception;

@SuppressWarnings("serial")
public class IngredientNotFoundException extends RuntimeException {
	public IngredientNotFoundException(String message) {
		super(message);
	}
}

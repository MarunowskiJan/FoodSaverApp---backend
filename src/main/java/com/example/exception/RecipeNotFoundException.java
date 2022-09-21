package com.example.exception;

@SuppressWarnings("serial")
public class RecipeNotFoundException extends RuntimeException {
	public RecipeNotFoundException(String message) {
		super(message);
	}
}

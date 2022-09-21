package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exception.IngredientNotFoundException;
import com.example.model.Ingredient;
import com.example.repository.IngredientRepository;

@Service
public class IngredientService {

	private final IngredientRepository ingredientRepository;

	@Autowired
	public IngredientService(IngredientRepository ingredientRepository) {
		this.ingredientRepository = ingredientRepository;
	}

	public Ingredient addIngredient(Ingredient ingredient) {
		return ingredientRepository.save(ingredient);
	}

	public List<Ingredient> findAllIngredients() {
		return ingredientRepository.findAll();
	}

	public Ingredient updateIngredient(Ingredient ingredient) {
		return ingredientRepository.save(ingredient);
	}

	public Ingredient findIngredientById(Long id) {
		return ingredientRepository.findIngredientById(id)
				.orElseThrow(() -> new IngredientNotFoundException("Ingredient with id:" + id + " doesn't exist"));
	}

	public void deleteIngredient(Long id) {
		ingredientRepository.deleteIngredientById(id);
	}
}

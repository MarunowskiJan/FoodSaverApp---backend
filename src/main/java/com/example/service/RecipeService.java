package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exception.RecipeNotFoundException;
import com.example.model.Recipe;
import com.example.repository.RecipeRepository;

@Service
public class RecipeService {

	private final RecipeRepository recipeRepository;

	@Autowired
	public RecipeService(RecipeRepository recipeRepository) {
		this.recipeRepository = recipeRepository;
	}

	public Recipe addRecipe(Recipe recipe) {
		return recipeRepository.save(recipe);
	}

	public List<Recipe> findAllRecipes() {
		return recipeRepository.findAll();
	}

	public Recipe updateRecipe(Recipe recipe) {
		return recipeRepository.save(recipe);
	}

	public Recipe findRecipeById(Long id) {
		return recipeRepository.findRecipeById(id)
				.orElseThrow(() -> new RecipeNotFoundException("Recipe with id: " + id + " doesn't exist"));
	}

	public void deleteRecipe(Long id) {
		recipeRepository.deleteRecipeById(id);
	}
}

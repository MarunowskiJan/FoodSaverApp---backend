package com.example.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.model.Ingredient;
import com.example.model.Recipe;
import com.example.service.IngredientService;
import com.example.service.RecipeService;

@RestController
@RequestMapping("/recipe")
public class RecipeController {
	private final RecipeService recipeService;
	private final IngredientService ingredientService;

	public RecipeController(RecipeService recipeService, IngredientService ingredientService) {
		this.ingredientService = ingredientService;
		this.recipeService = recipeService;
	}

	@GetMapping("/all")
	public ResponseEntity<List<Recipe>> getAllRecipes() {
		List<Recipe> recipes = recipeService.findAllRecipes();
		return new ResponseEntity<>(recipes, HttpStatus.OK);
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<Recipe> getRecipeById(@PathVariable("id") Long id) {
		Recipe recipe = recipeService.findRecipeById(id);
		return new ResponseEntity<>(recipe, HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<Recipe> addRecipe(@RequestBody Recipe recipe) {
		Recipe newRecipe = recipeService.addRecipe(recipe);
		return new ResponseEntity<>(newRecipe, HttpStatus.CREATED);
	}

	@PutMapping("/update")
	public ResponseEntity<Recipe> updateRecipe(@RequestBody Recipe recipe) {
		Recipe updateRecipe = recipeService.updateRecipe(recipe);
		return new ResponseEntity<>(updateRecipe, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteRecipe(@PathVariable("id") Long id) {
		recipeService.deleteRecipe(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/last")
	public ResponseEntity<Recipe> checkLastRecipe() {
		Recipe last = recipeService.findlastRecipeInRepository();
		return new ResponseEntity<Recipe>(last, HttpStatus.OK);
	}

	@PutMapping("/{recipeId}/ingredient/{ingredientId}")
	public ResponseEntity<Recipe> enrollIngredientToRecipe(@PathVariable("recipeId") Long recipeId,
			@PathVariable("ingredientId") Long ingredientId) {
		Recipe recipe = recipeService.findRecipeById(recipeId);
		Ingredient ingredient = ingredientService.findIngredientById(ingredientId);
		recipe.enrollIngredient(ingredient);
		Recipe _recipe = recipeService.addRecipe(recipe);
		return new ResponseEntity<>(_recipe, HttpStatus.OK);
	}
}

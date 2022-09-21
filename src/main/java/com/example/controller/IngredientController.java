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
import com.example.service.IngredientService;

@RestController
@RequestMapping("/ingredient")
public class IngredientController {
	private final IngredientService ingredientService;

	public IngredientController(IngredientService ingredientService) {
		this.ingredientService = ingredientService;
	}

	@GetMapping("/all")
	public ResponseEntity<List<Ingredient>> getAllIngredients() {
		List<Ingredient> ingredients = ingredientService.findAllIngredients();
		return new ResponseEntity<>(ingredients, HttpStatus.OK);
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<Ingredient> getIngredientById(@PathVariable("id") Long id) {
		Ingredient ingredient = ingredientService.findIngredientById(id);
		return new ResponseEntity<>(ingredient, HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<Ingredient> addIngredient(@RequestBody Ingredient ingredient) {
		Ingredient newIngredient = ingredientService.addIngredient(ingredient);
		return new ResponseEntity<>(newIngredient, HttpStatus.CREATED);
	}

	@PutMapping("/update")
	public ResponseEntity<Ingredient> updateIngredient(@RequestBody Ingredient ingredient) {
		Ingredient updateIngredient = ingredientService.updateIngredient(ingredient);
		return new ResponseEntity<>(updateIngredient, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteIngredient(@PathVariable("id") Long id) {
		ingredientService.deleteIngredient(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}

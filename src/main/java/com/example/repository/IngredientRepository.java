package com.example.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
	@Transactional
	void deleteIngredientById(Long id);

	Optional<Ingredient> findIngredientById(Long id);

}

package com.example.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import com.example.model.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

	@Transactional
	void deleteRecipeById(Long id);

	Optional<Recipe> findRecipeById(Long id);

	Recipe findTopByOrderByIdDesc();
}

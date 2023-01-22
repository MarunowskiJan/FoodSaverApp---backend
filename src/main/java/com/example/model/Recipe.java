package com.example.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "recipe")
public class Recipe {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "recipe_sequence")
	@SequenceGenerator(name = "recipe_sequence", initialValue = 31, allocationSize = 1)
	@Column(nullable = false, updatable = false)
	private Long id;
	private String name;
	private String imageUrl;
	private float rate = 0;
	private int serves;
	private int preparation;

	@ManyToMany
	@JoinTable(name = "recipe_has_ingredient", joinColumns = @JoinColumn(name = "recipe_id"), inverseJoinColumns = @JoinColumn(name = "ingredient_id"))
	private Set<Ingredient> enrolledIngredients = new HashSet<>();

	public Recipe() {
	}

	public Recipe(Long id, String name, String imageUrl, float rate, int serves, int preparation) {
		this.id = id;
		this.name = name;
		this.imageUrl = imageUrl;
		this.rate = rate;
		this.serves = serves;
		this.preparation = preparation;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

	public int getServes() {
		return serves;
	}

	public void setServes(int serves) {
		this.serves = serves;
	}

	public int getPreparation() {
		return preparation;
	}

	public void setPreparation(int preparation) {
		this.preparation = preparation;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Set<Ingredient> getEnrolledIngredients() {
		return enrolledIngredients;
	}

	public void enrollIngredient(Ingredient ingredient) {
		enrolledIngredients.add(ingredient);
	}
}

package com.xenon.simplyrecipes.repositories;

import com.xenon.simplyrecipes.entities.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}

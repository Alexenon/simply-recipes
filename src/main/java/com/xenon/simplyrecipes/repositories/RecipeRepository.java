package com.xenon.simplyrecipes.repositories;

import com.xenon.simplyrecipes.entities.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}

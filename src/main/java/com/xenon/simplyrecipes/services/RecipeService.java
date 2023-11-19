package com.xenon.simplyrecipes.services;

import com.xenon.simplyrecipes.entities.Recipe;
import com.xenon.simplyrecipes.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    public Optional<Recipe> getRecipeById(Long id) {
        return recipeRepository.findById(id);
    }

    public Recipe addRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    public Recipe saveRecipe(Recipe recipe) {
        Recipe savedRecipe = recipeRepository.save(recipe);
        recipe.setDateCreated(LocalDate.now());
        return savedRecipe;
    }

    public Recipe updateRecipe(Long id, Recipe updatedRecipe) {
        Recipe existingRecipe = recipeRepository.findById(id).orElseThrow();

        existingRecipe.setName(updatedRecipe.getName());
        existingRecipe.setDescription(updatedRecipe.getDescription());

        return recipeRepository.save(existingRecipe);
    }

    public void deleteRecipe(Long id) {
        recipeRepository.deleteById(id);
    }
}


package com.xenon.simplyrecipes.controllers;

import com.xenon.simplyrecipes.data.requests.RecipeRequest;
import com.xenon.simplyrecipes.entities.Recipe;
import com.xenon.simplyrecipes.services.CookingStepService;
import com.xenon.simplyrecipes.services.IngredientService;
import com.xenon.simplyrecipes.services.RecipeManagementService;
import com.xenon.simplyrecipes.services.RecipeService;
import com.xenon.simplyrecipes.utils.JsonObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @Autowired
    private RecipeManagementService recipeManagementService;

    @GetMapping("/all")
    public ResponseEntity<List<Recipe>> getAllRecipes() {
        List<Recipe> recipes = recipeService.getAllRecipes();
        return new ResponseEntity<>(recipes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recipe> getRecipeById(@PathVariable Long id) {
        Optional<Recipe> recipe = recipeService.getRecipeById(id);
        return recipe.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/add")
    public Recipe createRecipe(@RequestBody RecipeRequest request) {
        Recipe receivedRecipe = JsonObjectMapper.toRecipe(request);
        return recipeManagementService.saveRecipe(receivedRecipe);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Recipe> updateRecipe(@PathVariable Long id, @RequestBody Recipe updatedRecipe) {
        Recipe updated = recipeService.updateRecipe(id, updatedRecipe);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecipe(@PathVariable Long id) {
        recipeService.deleteRecipe(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

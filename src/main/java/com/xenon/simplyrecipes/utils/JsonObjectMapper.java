package com.xenon.simplyrecipes.utils;

import com.xenon.simplyrecipes.data.requests.CategoryRequest;
import com.xenon.simplyrecipes.data.requests.IngredientRequest;
import com.xenon.simplyrecipes.data.requests.RecipeRequest;
import com.xenon.simplyrecipes.entities.Category;
import com.xenon.simplyrecipes.entities.Ingredient;
import com.xenon.simplyrecipes.entities.Recipe;

public class JsonObjectMapper {

    public static Category toCategory(CategoryRequest request) {
        Category category = new Category();
        category.setName(request.getName());
        return category;
    }

    public static Ingredient toIngredient(IngredientRequest request) {
        Ingredient ingredient = new Ingredient();
        ingredient.setName(request.getName());
        ingredient.setAmount(request.getAmount());
        return ingredient;
    }

    public static Recipe toRecipe(RecipeRequest request) {
        Recipe recipe = new Recipe();
        recipe.setName(request.getName());
        recipe.setDescription(request.getDescription());
        recipe.setImageName(request.getImageName());
        recipe.setPreparingDuration(request.getPreparingDuration());
        recipe.setCategories(request.getCategories());
        recipe.setIngredients(request.getIngredients());
        recipe.setCookingSteps(request.getCookingSteps());

        return recipe;
    }

}

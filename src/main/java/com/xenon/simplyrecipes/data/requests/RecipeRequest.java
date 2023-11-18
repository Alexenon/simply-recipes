package com.xenon.simplyrecipes.data.requests;

import com.xenon.simplyrecipes.entities.Comment;
import com.xenon.simplyrecipes.entities.RecipeCookingStep;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class RecipeRequest {
    String name;
    String description;
    String imageName;
    Integer preparingDuration; // In minutes
    List<IngredientRequest> recipeCategories;
    List<CategoryRequest> recipeIngredients;
    RecipeCookingStep recipeCookingStep;
    List<Comment> comments;
    LocalDate dateCreated;
}

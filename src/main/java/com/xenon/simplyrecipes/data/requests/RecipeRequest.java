package com.xenon.simplyrecipes.data.requests;

import com.xenon.simplyrecipes.entities.Category;
import com.xenon.simplyrecipes.entities.Comment;
import com.xenon.simplyrecipes.entities.CookingStep;
import com.xenon.simplyrecipes.entities.Ingredient;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class RecipeRequest {
    String name;
    String description;
    String imageName;
    Integer preparingDuration;
    Integer cookingDuration;
    Set<Category> categories;
    List<Ingredient> ingredients;
    List<CookingStep> cookingSteps;
    List<Comment> comments;
}

package com.xenon.simplyrecipes.services;

import com.xenon.simplyrecipes.entities.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipeManagementService {

    @Autowired
    private RecipeService recipeService;

    @Autowired
    private CookingStepService cookingStepService;

    @Autowired
    private IngredientService ingredientService;

    @Autowired
    private CommentService commentService;

    public Recipe saveRecipe(Recipe recipe) {
        Recipe savedRecipe = recipeService.saveRecipe(recipe);
        linkRelationshipsForRecipe(savedRecipe);
        return savedRecipe;
    }

    // TODO: Comments are not linked with user

    /**
     * Store in database ingredients, cooking steps, and comments provided in request
     */
    private void linkRelationshipsForRecipe(Recipe recipe) {
        linkIngredientsForRecipe(recipe);
        linkCookingStepsForRecipe(recipe);
        linkCommentsForRecipe(recipe);
    }

    private void linkIngredientsForRecipe(Recipe recipe) {
        if (recipe.getIngredients() != null) {
            recipe.getIngredients().forEach(ingredient -> ingredient.setRecipe(recipe));
            ingredientService.addIngredients(recipe.getIngredients());
        }
    }

    private void linkCookingStepsForRecipe(Recipe recipe) {
        if (recipe.getCookingSteps() != null) {
            recipe.getCookingSteps().forEach(cookingStep -> cookingStep.setRecipe(recipe));
            cookingStepService.addCookingSteps(recipe.getCookingSteps());
        }
    }

    private void linkCommentsForRecipe(Recipe recipe) {
        if (recipe.getComments() != null) {
            recipe.getComments().forEach(comment -> comment.setRecipe(recipe));
            commentService.addComments(recipe.getComments());
        }
    }


}

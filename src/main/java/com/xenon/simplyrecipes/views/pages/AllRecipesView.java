package com.xenon.simplyrecipes.views.pages;

import com.vaadin.flow.component.html.Main;
import com.xenon.simplyrecipes.services.RecipeService;
import com.xenon.simplyrecipes.views.components.RecipeCardLayout;
import org.springframework.beans.factory.annotation.Autowired;

public class AllRecipesView extends Main {

    @Autowired
    private RecipeService recipeService;

    public AllRecipesView(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    private void initialize() {

        recipeService.getAllRecipes().forEach(recipe -> {
            add(new RecipeCardLayout(recipe));
        });

    }

    private void costumize() {

    }

}

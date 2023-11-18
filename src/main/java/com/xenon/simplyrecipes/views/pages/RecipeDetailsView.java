package com.xenon.simplyrecipes.views.pages;

import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.xenon.simplyrecipes.entities.Recipe;
import com.xenon.simplyrecipes.views.MainLayout;
import org.springframework.beans.factory.annotation.Autowired;

@PageTitle("Recipe Details")
@Route(value = "recipe-details", layout = MainLayout.class)
public class RecipeDetailsView {

    @Autowired
    Recipe recipe;

    public RecipeDetailsView(Recipe recipe) {
        this.recipe = recipe;
        initialize();
        costumize();
    }

    private void initialize() {

    }

    private void costumize() {

    }

}

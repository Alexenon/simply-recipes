package com.xenon.simplyrecipes.views.pages;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.router.*;
import com.xenon.simplyrecipes.entities.Recipe;
import com.xenon.simplyrecipes.services.CategoryService;
import com.xenon.simplyrecipes.services.RecipeService;
import com.xenon.simplyrecipes.views.MainLayout;
import com.xenon.simplyrecipes.views.components.RecipeCardLayout;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@PageTitle("Recipes")
@Route(value = "recipes", layout = MainLayout.class)
public class RecipesView extends Main implements HasUrlParameter<String> {

    @Autowired
    private RecipeService recipeService;

    @Autowired
    private CategoryService categoryService;

    private List<Recipe> listOfRecipes;

    public RecipesView(RecipeService recipeService, CategoryService categoryService) {
        this.recipeService = recipeService;
        this.categoryService = categoryService;

        addClassName("container");
    }

    @Override
    public void setParameter(BeforeEvent event, @OptionalParameter String categoryName) {
        listOfRecipes = categoryName == null || categoryName.isEmpty()
                ? recipeService.getAllRecipes()
                : recipeService.getRecipesByCategory(categoryName);

        initialize();
    }

    private void initialize() {
        Div pageContent = new Div();
        pageContent.addClassName("page-content");

        listOfRecipes.forEach(recipe -> pageContent.add(new RecipeCardLayout(recipe)));

        add(
                new H2("Welcome to Simply Recipes!"),
                pageContent
        );
    }


}

package com.xenon.simplyrecipes.views.pages;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.xenon.simplyrecipes.entities.Recipe;
import com.xenon.simplyrecipes.views.MainLayout;
import com.xenon.simplyrecipes.views.components.RecipeCardLayout;

import java.time.LocalDate;

@PageTitle("Home")
@Route(value = "", layout = MainLayout.class)
@CssImport("./themes/my-theme/css/card.css")
public class HomeView extends Main {

    AddRecipeDialog addRecipeDialog = new AddRecipeDialog();

    public HomeView() {
        add(new H2("Welcome to Simply Recipes!"));
        addClassName("container");

        Button addReceipeBtn = new Button("Add Recipe", e -> addRecipeDialog.open());
        add(addReceipeBtn);

        Recipe recipe = new Recipe();
        recipe.setName("Pizza");
        recipe.setDescription("Pepperoni is a variety of spicy salami made from cured pork and beef seasoned with paprika or other chili pepper. Prior to cooking, pepperoni is characteristically soft, slightly smoky, and bright red.");
        recipe.setPreparingDuration(300);
        recipe.setImageName("pizza.jpg");
        recipe.setComments(null);
        recipe.setRecipeCategories(null);
        recipe.setRecipeCookingStep(null);
        recipe.setDateCreated(LocalDate.now());

        RecipeCardLayout recipeCardLayout = new RecipeCardLayout(recipe);
        add(recipeCardLayout);
    }
}

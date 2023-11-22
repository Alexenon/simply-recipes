package com.xenon.simplyrecipes.views.pages;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.xenon.simplyrecipes.entities.Category;
import com.xenon.simplyrecipes.entities.Recipe;
import com.xenon.simplyrecipes.views.MainLayout;
import com.xenon.simplyrecipes.views.components.AddRecipeDialog;
import com.xenon.simplyrecipes.views.components.RecipeCardLayout;
import org.hibernate.mapping.List;

import java.time.LocalDate;
import java.util.ArrayList;

@PageTitle("Home")
@Route(value = "", layout = MainLayout.class)
public class HomeView extends Main {

    AddRecipeDialog addRecipeDialog = new AddRecipeDialog();

    public HomeView() {
        add(new H2("Welcome to Simply Recipes!"));
        addClassName("container");

        Button addRecipe = new Button("Add Recipe", e -> addRecipeDialog.open());
        add(addRecipe);

        Recipe recipe = new Recipe();
        recipe.setName("Pizza");
        recipe.setDescription("Pepperoni is a variety of spicy salami made from cured pork and beef seasoned with paprika or other chili pepper. Prior to cooking, pepperoni is characteristically soft, slightly smoky, and bright red.");
        recipe.setPreparingDuration(10);
        recipe.setCookingDuration(300);
        recipe.setImageName("pizza.jpg");
        recipe.setComments(null);

        recipe.setCategories(null);
        recipe.setCookingSteps(null);
        recipe.setDateCreated(LocalDate.now());

        Div pageContent = new Div();
        pageContent.addClassName("page-content");

        pageContent.add(new RecipeCardLayout(recipe));
        pageContent.add(new RecipeCardLayout(recipe));
        pageContent.add(new RecipeCardLayout(recipe));
        pageContent.add(new RecipeCardLayout(recipe));
        pageContent.add(new RecipeCardLayout(recipe));
        pageContent.add(new RecipeCardLayout(recipe));
        pageContent.add(new RecipeCardLayout(recipe));
        pageContent.add(new RecipeCardLayout(recipe));
        pageContent.add(new RecipeCardLayout(recipe));

        add(pageContent);
    }
}

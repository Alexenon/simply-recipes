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

    private String categoryName;

    public RecipesView(RecipeService recipeService, CategoryService categoryService) {
        this.recipeService = recipeService;
        this.categoryService = categoryService;

        addClassName("page-content");
    }

    @Override
    public void setParameter(BeforeEvent event, @OptionalParameter String categoryName) {
        this.categoryName = categoryName;

        initialize();
    }

    private void initialize() {
        Div wrapper = new Div();
        wrapper.addClassName("recipe-wrapper");
        getListOfRecipes().forEach(recipe -> wrapper.add(new RecipeCardLayout(recipe)));

        Div pageContent = new Div(getPageTitle(), wrapper);
//        pageContent.addClassName("page-content");

        add(pageContent);
    }

    private H2 getPageTitle() {
        String titleText = categoryName == null || categoryName.isEmpty()
                ? "Recipes"
                : categoryName + " Recipes";
        H2 title = new H2(titleText);
        title.addClassName("recipe-header");
        return title;
    }

    private List<Recipe> getListOfRecipes() {
        return categoryName == null || categoryName.isEmpty()
                ? recipeService.getAllRecipes()
                : recipeService.getRecipesByCategory(categoryName);
    }


}

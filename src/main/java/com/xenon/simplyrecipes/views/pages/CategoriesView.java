package com.xenon.simplyrecipes.views.pages;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.xenon.simplyrecipes.entities.Category;
import com.xenon.simplyrecipes.services.CategoryService;
import com.xenon.simplyrecipes.services.RecipeService;
import com.xenon.simplyrecipes.views.MainLayout;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@PageTitle("Categories")
@Route(value = "/categories", layout = MainLayout.class)
public class CategoriesView extends Main {

    @Autowired
    private RecipeService recipeService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    public CategoriesView(RecipeService recipeService, CategoryService categoryService) {
        this.recipeService = recipeService;
        this.categoryService = categoryService;

        List<Category> listOfCategories;
        listOfCategories = categoryService.getAllCategories();
        listOfCategories.forEach(c -> add(getCategoryDiv(c)));
    }

    private int getCategoryCount(String categoryName) {
        return recipeService.getRecipesByCategory(categoryName).size();
    }

    private Div getCategoryDiv(Category category) {
        Paragraph categoryNameParagraph = new Paragraph(category.getName());
        String categoryCount = String.valueOf(getCategoryCount(category.getName()));
        Paragraph categoryCountParagraph = new Paragraph(categoryCount);

        Div categoryDiv = new Div(categoryNameParagraph, categoryCountParagraph);
        categoryDiv.addClassName("category-container");
        return categoryDiv;
    }

}

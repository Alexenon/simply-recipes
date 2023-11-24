package com.xenon.simplyrecipes.views.pages;

import com.vaadin.flow.component.html.*;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.xenon.simplyrecipes.entities.Category;
import com.xenon.simplyrecipes.services.CategoryService;
import com.xenon.simplyrecipes.services.RecipeService;
import com.xenon.simplyrecipes.views.MainLayout;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/*
 * https://www.youtube.com/watch?v=-8LTPIJBGwQ
 * */

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

        addClassName("category-wrapper");

        Section section = new Section();
        section.addClassName("columns");

        List<Category> listOfCategories;
        listOfCategories = categoryService.getAllCategories();
        listOfCategories.forEach(c -> {
            Div column = new Div(getCategoryDiv(c));
            column.addClassName("column");
            section.add(column);
        });

        add(section);
    }

    private int getCategoryCount(String categoryName) {
        return recipeService.getRecipesByCategory(categoryName).size();
    }

    private Div getCategoryDiv(Category category) {
        Div arrow = new Div();
        arrow.addClassName("arrow");
        H2 categoryNameParagraph = new H2(category.getName());
        String countText = String.valueOf(getCategoryCount(category.getName()));
        Paragraph categoryCountParagraph = new Paragraph(countText + " recipe");

        Div categoryCard = new Div(categoryNameParagraph, categoryCountParagraph);
        categoryCard.addClassName("category-card");
        return categoryCard;
    }

}

package com.xenon.simplyrecipes.views;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.html.Paragraph;
import com.xenon.simplyrecipes.views.pages.AddRecipeView;
import com.xenon.simplyrecipes.views.pages.CategoriesView;

public class MainLayout extends AppLayout {

    public MainLayout() {
        super();

        Paragraph addRecipe = new Paragraph("Add Recipe");
        addRecipe.addClickListener(e -> getUI().ifPresent(ui -> ui.navigate(AddRecipeView.class)));

        Paragraph categories = new Paragraph("Categories");
        categories.addClickListener(e -> getUI().ifPresent(ui -> ui.navigate(CategoriesView.class)));

        addToNavbar(addRecipe, categories);
    }
}

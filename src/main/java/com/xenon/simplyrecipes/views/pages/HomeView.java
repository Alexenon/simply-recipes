package com.xenon.simplyrecipes.views.pages;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.xenon.simplyrecipes.views.MainLayout;

@PageTitle("Home")
@Route(value = "", layout = MainLayout.class)
public class HomeView extends Main {

    AddRecipeDialog addRecipeDialog = new AddRecipeDialog();

    public HomeView() {
        add(new H2("Welcome to Simply Recipes!"));

        Button addReceipeBtn = new Button("Add Recipe", e -> addRecipeDialog.open());
        add(addReceipeBtn);

    }
}

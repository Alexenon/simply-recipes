package com.xenon.simplyrecipes;

import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Home")
@Route(value = "", layout = MainLayout.class)
public class HomeView extends Main {

    public HomeView() {
        add(new H2("Welcome to Simply Recipes!"));
    }
}

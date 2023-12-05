package com.xenon.simplyrecipes.views.components;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Nav;
import com.vaadin.flow.router.RouterLink;
import com.xenon.simplyrecipes.views.pages.CategoriesView;
import com.xenon.simplyrecipes.views.pages.HomeView;
import com.xenon.simplyrecipes.views.pages.RecipesView;

import java.util.List;

@Tag(Tag.NAV)
public class NavigationBar extends Nav {

    private final Image logoImage = new Image("/images/logo-white-background.png", "Logo image");
    private final RouterLink dashboardLink = new RouterLink("Recipes", RecipesView.class);
    private final RouterLink expensesLink = new RouterLink("Categories", CategoriesView.class);

    public NavigationBar() {
        addClassName("navbar");
        Div innerMenu = new Div();
        innerMenu.addClassName("menu-inner");
        innerMenu.add(getRoutes());

        Div menu = new Div(innerMenu);
        menu.setClassName("menu");

        add(menu);
        addStyle();
    }

    private void addStyle() {
        getRoutes().forEach(e -> e.setClassName("menu-item"));
        logoImage.addClassNames("logo");
        logoImage.addClickListener(e -> getUI().ifPresent(ui -> ui.navigate(HomeView.class)));
    }

    public List<Component> getRoutes() {
        return List.of(logoImage, expensesLink, dashboardLink);
    }

}
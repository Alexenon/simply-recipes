package com.xenon.simplyrecipes.views;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.xenon.simplyrecipes.views.components.NavigationBar;

public class MainLayout extends AppLayout {

    public MainLayout() {
        addToNavbar(getHeader());
    }

    private Header getHeader() {
        Header header = new Header();
        header.setId("header");

        Icon personIcon = new Icon(VaadinIcon.USER);
        personIcon.addClassName("user-icon");

        NavigationBar navbar = new NavigationBar();
        navbar.add(personIcon);
        header.add(navbar);

        return header;
    }
}

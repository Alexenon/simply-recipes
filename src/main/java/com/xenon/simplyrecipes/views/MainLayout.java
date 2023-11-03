package com.xenon.simplyrecipes.views;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.html.Paragraph;

public class MainLayout extends AppLayout {

    public MainLayout() {
        super();
        addToNavbar(new Paragraph("Link"));
    }
}

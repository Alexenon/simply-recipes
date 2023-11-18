package com.xenon.simplyrecipes.views;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.html.Paragraph;
import com.xenon.simplyrecipes.views.components.AddRecipeDialog;

public class MainLayout extends AppLayout {

    public MainLayout() {
        super();
        final Paragraph link = new Paragraph("Link");
        link.addClickListener(e -> getUI().ifPresent(ui -> ui.navigate(AddRecipeDialog.class)));
        addToNavbar(link);
    }
}

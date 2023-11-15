package com.xenon.simplyrecipes.views.components;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.xenon.simplyrecipes.entities.Recipe;

//https://codepen.io/FairyWsr/details/RwvpzaE
public class RecipeCardLayout extends Div {

    private static final String FOLDER_LOCATION = "./images/";

    private Recipe recipe;

    H2 title;
    Image image;
    Paragraph description;
    Paragraph duration = new Paragraph();
    Button showBtn = new Button("Show");

    public RecipeCardLayout(Recipe recipe) {
        this.recipe = recipe;
        title = new H2(recipe.getName());
        image = new Image();
        image.setSrc(FOLDER_LOCATION + recipe.getImageName());
        image.setAlt(recipe.getImageName());
        description = new Paragraph(recipe.getDescription());
        duration.setText(recipe.getPreparingDuration().toString() + " mins");
        initialize();
    }

    private void initialize() {
        this.addClassName("card");

        Div imageContainer = new Div(image);
        imageContainer.addClassName("image");

        Div cardContent = new Div(title, description);
        cardContent.addClassName("content");

        Div durationDiv = new Div(VaadinIcon.CLOSE_SMALL.create(), duration);
        Div cardFooter = new Div(durationDiv, showBtn);


        add(imageContainer, cardContent, cardFooter);
    }

}

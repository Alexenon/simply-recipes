package com.xenon.simplyrecipes.views.components;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.xenon.simplyrecipes.entities.Recipe;
import com.xenon.simplyrecipes.views.pages.RecipeDetailsView;

//https://codepen.io/FairyWsr/details/RwvpzaE
public class RecipeCardLayout extends Div {

    private static final String FOLDER_LOCATION = "./images/";
    private final Recipe recipe;
    H2 title;
    Image image;
    Paragraph description;
    Paragraph preparingDuration = new Paragraph();
    Paragraph cookingDuration = new Paragraph();
    Button showBtn = new Button("Show", new Icon(VaadinIcon.ARROW_RIGHT));

    public RecipeCardLayout(Recipe recipe) {
        this.recipe = recipe;

        title = new H2(recipe.getName());
        image = new Image();
        image.setSrc(FOLDER_LOCATION + recipe.getImageName());
        image.setAlt(recipe.getImageName());
        description = new Paragraph(recipe.getDescription());
        preparingDuration.setText(recipe.getPreparingDuration().toString() + " mins");
        cookingDuration.setText(recipe.getCookingDuration().toString() + " mins");

        initialize();
        costumize();
    }

    private void initialize() {
        this.addClassName("card");

        Div imageContainer = new Div(image);
        imageContainer.addClassName("image");

        String text = String.format("Prep : %d min | Cook : %d min",
                recipe.getPreparingDuration(), recipe.getCookingDuration());
        Paragraph p = new Paragraph(text);
        Div durationDiv = new Div(VaadinIcon.CLOCK.create(), p);
        durationDiv.addClassName("duration");
        Div cardFooter = new Div(durationDiv, showBtn);
        cardFooter.addClassName("card-footer");

        Div cardContent = new Div(title, description, cardFooter);
        cardContent.addClassName("content");

        add(imageContainer, cardContent, cardFooter);
    }

    private void costumize() {
        showBtn.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_SUCCESS);
        showBtn.setIconAfterText(true);
        showBtn.addClickListener(e -> {
//            Long recipeId = recipe.getId();
            Long recipeId = 1L;
            UI.getCurrent().navigate(RecipeDetailsView.class, recipeId);
        });
    }

    public Recipe getRecipe() {
        return recipe;
    }

}

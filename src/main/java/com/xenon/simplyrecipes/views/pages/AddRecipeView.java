package com.xenon.simplyrecipes.views.pages;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.Lumo;
import com.xenon.simplyrecipes.models.Ingredient;

import java.util.ArrayList;
import java.util.List;

@Route("add-recipe")
@PageTitle("Add Recipe")
public class AddRecipeView extends VerticalLayout {

    TextField recipeName = new TextField("Recipe name");
    TextField recipeDescription = new TextField("Recipe description");
    TextField ingredientName = new TextField("Ingredient name");
    TextField ingredientAmount = new TextField("Amount");

    List<IngredientLayout> ingredientLayouts = new ArrayList<>();
    Button addIngredientBtn = new Button("Add ingredient");

    List<Ingredient> ingredients = new ArrayList<>();

    public AddRecipeView() {
        add(recipeName, recipeDescription);
        HorizontalLayout layout = new HorizontalLayout(ingredientName, ingredientAmount, addIngredientBtn);
        add(layout);

        addIngredientBtn.addClickListener(e -> {
            addIngredient();
            ingredientName.setValue("");
            ingredientAmount.setValue("");
        });
    }

    private void addIngredient() {
        IngredientLayout newIngredientLayout = new IngredientLayout();
        ingredientLayouts.add(newIngredientLayout);
        add(newIngredientLayout);
    }

    private class IngredientLayout extends HorizontalLayout {
        Paragraph ingredientName = new Paragraph("Ingredient name");
        Paragraph ingredientAmount = new Paragraph("Amount");
        Icon removeIcon = VaadinIcon.TRASH.create();

        public IngredientLayout() {
            add(ingredientName, ingredientAmount, removeIcon);

            removeIcon.setColor("red");
            removeIcon.addClickListener(event -> {
                ingredientLayouts.remove(this);
                this.removeFromParent();
            });
        }

        public Ingredient getIngredient() {
            return new Ingredient(
                    ingredientName.getText(),
                    Integer.parseInt(ingredientAmount.getText())
            );
        }
    }
}




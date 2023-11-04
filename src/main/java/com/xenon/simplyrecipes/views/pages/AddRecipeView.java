package com.xenon.simplyrecipes.views.pages;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.xenon.simplyrecipes.models.Ingredient;

import java.util.ArrayList;
import java.util.List;

@Route("add-recipe")
@PageTitle("Add Recipe")
public class AddRecipeView extends VerticalLayout {
    private static final int DEFAULT_INGREDIENT_AMOUNT = 0;

    TextField recipeName = new TextField("Recipe name");
    TextArea recipeDescription = new TextArea("Description");
    TextField ingredientName = new TextField("Ingredient name");
    IntegerField ingredientAmount = new IntegerField("Amount");
    Button addIngredientBtn = new Button("Add ingredient");

    List<Ingredient> ingredients = new ArrayList<>();

    public AddRecipeView() {
        add(recipeName, recipeDescription);
        HorizontalLayout layout = new HorizontalLayout(ingredientName, ingredientAmount, addIngredientBtn);
        layout.setDefaultVerticalComponentAlignment(Alignment.CENTER);

        addStyle();
        add(layout);
    }

    private void addStyle() {
        ingredientName.addClassName("ingredient-name");
        ingredientName.setHelperText("Example: Eggs");

        ingredientAmount.setMin(DEFAULT_INGREDIENT_AMOUNT);
        ingredientAmount.setValue(DEFAULT_INGREDIENT_AMOUNT);
        ingredientAmount.setStepButtonsVisible(true);
        ingredientAmount.setHelperText("");

        addIngredientBtn.addClassName("add-ingredient-btn");
        addIngredientBtn.addClickListener(e -> {
            IngredientLayout ingredientLayoutFromFields = getIngredientLayoutFromFields();
            add(ingredientLayoutFromFields);
            ingredientName.setValue("");
            ingredientAmount.setValue(DEFAULT_INGREDIENT_AMOUNT);
        });
    }

    private IngredientLayout getIngredientLayoutFromFields() {
        return new IngredientLayout(ingredientName.getValue(), ingredientAmount.getValue());
    }

    private static class IngredientLayout extends HorizontalLayout {
        private final Paragraph ingredientName;
        private final Paragraph ingredientAmount;
        private final Icon removeIcon = VaadinIcon.CLOSE_SMALL.create();

        public IngredientLayout(String ingredientName, int ingredientAmount) {
            this.ingredientName = new Paragraph(ingredientName);
            this.ingredientAmount = new Paragraph(String.valueOf(ingredientAmount));

            addStyle();
            Checkbox checkbox = new Checkbox();

            addClassName("ingredient-layout");
            setDefaultVerticalComponentAlignment(Alignment.CENTER);
            add(checkbox, this.ingredientName, this.ingredientAmount, removeIcon);
        }

        private void addStyle() {
            removeIcon.setColor("red");
            removeIcon.addClickListener(event -> this.removeFromParent());
        }

        public Ingredient getIngredient() {
            return new Ingredient(
                    ingredientName.getText(),
                    Integer.parseInt(ingredientAmount.getText())
            );
        }
    }

}




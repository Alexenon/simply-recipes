package com.xenon.simplyrecipes.views.components;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.TextField;
import com.xenon.simplyrecipes.entities.Ingredient;

import java.util.ArrayList;
import java.util.List;

public class IngredientUploader extends VerticalLayout {

    private static List<Ingredient> ingredientList;

    private final TextField ingredientName = new TextField("Ingredient name");
    private final IntegerField ingredientAmount = new IntegerField("Amount");
    private final Button addIngredientBtn = new Button("Add ingredient");

    public IngredientUploader() {
        ingredientList = new ArrayList<>();
        initialize();
        addStyle();
    }

    private void initialize() {
        HorizontalLayout layoutForFields = new HorizontalLayout(ingredientName, ingredientAmount, addIngredientBtn);
        layoutForFields.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
        add(layoutForFields);
    }

    private void addStyle() {
        ingredientName.addClassName("ingredient-name");
        ingredientName.setHelperText("Example: Eggs");
        ingredientName.setRequired(true);
        ingredientName.setMinLength(3);

        ingredientAmount.setRequired(true);
        ingredientAmount.setMin(0);
        ingredientAmount.setValue(0);
        ingredientAmount.setStepButtonsVisible(true);
        ingredientAmount.setHelperText("");

        addIngredientBtn.addClassName("add-ingredient-btn");
        addIngredientBtn.addClickListener(e -> {
            if(ingredientName.isEmpty()) return;

            IngredientLayout ingredientLayoutFromFields = getIngredientLayoutFromFields();
            add(ingredientLayoutFromFields);
            ingredientList.add(ingredientLayoutFromFields.getIngredient());
            clearFields();
        });
    }

    private IngredientLayout getIngredientLayoutFromFields() {
        return new IngredientLayout(ingredientName.getValue(), ingredientAmount.getValue());
    }

    private void clearFields() {
        ingredientName.setValue("");
        ingredientAmount.setValue(0);
    }

    public List<Ingredient> getIngredientList() {
        return ingredientList;
    }

}

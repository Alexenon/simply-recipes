package com.xenon.simplyrecipes.views.pages;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.theme.lumo.LumoIcon;
import com.xenon.simplyrecipes.models.Ingredient;
import com.xenon.simplyrecipes.models.Recipe;
import com.xenon.simplyrecipes.views.components.UploadImage;

import java.util.ArrayList;
import java.util.List;

/*
* https://food52.com/recipes/new
* */

public class AddRecipeDialog extends Dialog {
    private static final int DEFAULT_INGREDIENT_AMOUNT = 0;

    private final TextField receipeTitle = new TextField("Recipe Title");
    private final TextArea receipeDescription = new TextArea("Description");
    private final IntegerField receipeDuration = new IntegerField("Duration");

    private final UploadImage uploadImage = new UploadImage();

    private final TextField ingredientName = new TextField("Ingredient name");
    private final IntegerField ingredientAmount = new IntegerField("Amount");
    private final Button addIngredientBtn = new Button("Add ingredient");

    private final List<Ingredient> ingredients = new ArrayList<>();

    public AddRecipeDialog() {
        VerticalLayout dialogLayout = new VerticalLayout(uploadImage, receipeTitle, receipeDescription, receipeDuration);

        HorizontalLayout layoutForIngredients = new HorizontalLayout(ingredientName, ingredientAmount, addIngredientBtn);
        layoutForIngredients.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);

        dialogLayout.add(layoutForIngredients);
        add(dialogLayout);

        setupDialog();
        addStyle();
        add(layoutForIngredients);
    }

    public Recipe getReceipe() {
        return new Recipe(
                receipeTitle.getValue(),
                receipeDescription.getValue(),
                ingredients,
                receipeDuration.getValue(),
                uploadImage.getUploadedFilePath()
        );
    }

    private void setupDialog() {
        this.setHeaderTitle("Add a new receipe");

        Button cancelButton = new Button("Cancel", (e) -> this.close());
        cancelButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        cancelButton.getStyle().set("margin-right", "auto");
        this.getFooter().add(cancelButton);

        Button saveButton = new Button("Save", (e) -> this.close());
        saveButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_SUCCESS);
        this.getFooter().add(saveButton);
    }

    private void addStyle() {
        receipeTitle.addClassName("dialog-field");
        receipeDescription.addClassName("dialog-field");

        ingredientName.addClassName("ingredient-name");
        ingredientName.setHelperText("Example: Eggs");

        receipeDuration.setMin(0);
        receipeDuration.setValue(0);
        receipeDuration.setStepButtonsVisible(true);
        receipeDuration.setStep(5);

        Paragraph helperText = new Paragraph("Duration in minutes");
        helperText.getStyle().set("display", "inline");
        Div div = new Div(LumoIcon.CLOCK.create(), helperText);
        div.getStyle().set("display", "inline");
        receipeDuration.setHelperComponent(div);

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
            add(checkbox, this.ingredientName, this.ingredientAmount, removeIcon);
        }

        private void addStyle() {
            setDefaultVerticalComponentAlignment(Alignment.CENTER);
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




package com.xenon.simplyrecipes.views.pages;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoIcon;
import com.xenon.simplyrecipes.entities.Ingredient;
import com.xenon.simplyrecipes.entities.Recipe;
import com.xenon.simplyrecipes.services.RecipeManagementService;
import com.xenon.simplyrecipes.views.MainLayout;
import com.xenon.simplyrecipes.views.components.IngredientLayout;
import com.xenon.simplyrecipes.views.components.UploadImage;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/*
 * https://food52.com/recipes/new
 * */

@PageTitle("Add Recipe")
@Route(value = "", layout = MainLayout.class)
public class AddRecipeView extends Main {

    private static final int DEFAULT_INGREDIENT_AMOUNT = 0;

    private final RecipeManagementService recipeManagementService;

    private final TextField receipeTitle = new TextField("Recipe Title");
    private final TextArea receipeDescription = new TextArea("Description");
    private final IntegerField receipeDuration = new IntegerField("Duration");

    private final UploadImage uploadImage = new UploadImage();

    private final TextField ingredientName = new TextField("Ingredient name");
    private final IntegerField ingredientAmount = new IntegerField("Amount");
    private final Button addIngredientBtn = new Button("Add ingredient");

    private final List<Ingredient> ingredients = new ArrayList<>();

    @Autowired
    public AddRecipeView(RecipeManagementService recipeManagementService) {
        this.recipeManagementService = recipeManagementService;
    }


    public void initialize() {
        VerticalLayout dialogLayout = new VerticalLayout(uploadImage, receipeTitle, receipeDescription, receipeDuration);

        HorizontalLayout layoutForIngredients = new HorizontalLayout(ingredientName, ingredientAmount, addIngredientBtn);
        layoutForIngredients.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);

        dialogLayout.add(layoutForIngredients);
        add(dialogLayout);

        addStyle();
        add(layoutForIngredients);
    }

    public Recipe getReceipe() {
        Recipe recipeToBeSaved = new Recipe();
        recipeToBeSaved.setName(receipeTitle.getValue());
        recipeToBeSaved.setDescription(receipeDescription.getValue());
        recipeToBeSaved.setPreparingDuration(receipeDuration.getValue());
        recipeToBeSaved.setIngredients(null);
        recipeToBeSaved.setComments(null);

        recipeToBeSaved.setDateCreated(LocalDate.now());

        return recipeToBeSaved;
    }

//    private void setupDialog() {
//        this.setHeaderTitle("Add a new receipe");
//
//        Button cancelButton = new Button("Cancel", (e) -> this.close());
//        cancelButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
//        cancelButton.getStyle().set("margin-right", "auto");
//        this.getFooter().add(cancelButton);
//
//        Button saveButton = new Button("Save", (e) -> this.close());
//        saveButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_SUCCESS);
//        this.getFooter().add(saveButton);
//    }

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
            clearFields();
        });
    }

    private IngredientLayout getIngredientLayoutFromFields() {
        return new IngredientLayout(ingredientName.getValue(), ingredientAmount.getValue());
    }

    private void clearFields() {
        ingredientName.setValue("");
        ingredientAmount.setValue(DEFAULT_INGREDIENT_AMOUNT);
    }

}

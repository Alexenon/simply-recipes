package com.xenon.simplyrecipes.views.pages;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.MultiSelectComboBox;
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
import com.xenon.simplyrecipes.entities.Category;
import com.xenon.simplyrecipes.entities.CookingStep;
import com.xenon.simplyrecipes.entities.Ingredient;
import com.xenon.simplyrecipes.entities.Recipe;
import com.xenon.simplyrecipes.services.CategoryService;
import com.xenon.simplyrecipes.services.RecipeManagementService;
import com.xenon.simplyrecipes.views.MainLayout;
import com.xenon.simplyrecipes.views.components.IngredientLayout;
import com.xenon.simplyrecipes.views.components.IngredientUpload;
import com.xenon.simplyrecipes.views.components.UploadImage;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/*
 * https://food52.com/recipes/new
 * */

@PageTitle("Add Recipe")
@Route(value = "/develop", layout = MainLayout.class)
public class AddRecipeView extends Main {

    private final CategoryService categoryService;
    private final RecipeManagementService recipeManagementService;

    private final UploadImage uploadImage = new UploadImage();
    private final TextField recipeTitle = new TextField("Recipe Title");
    private final TextArea recipeDescription = new TextArea("Description");
    private final MultiSelectComboBox<Category> categoryMultiselect = new MultiSelectComboBox<>("Categories");
    private final IntegerField recipePreparingDuration = new IntegerField("Preparing duration");
    private final IntegerField recipeCookingDuration = new IntegerField("Cooking duration");
    private final IngredientUpload ingredientUpload = new IngredientUpload();

    private final List<Ingredient> listOfIngredients = new ArrayList<>();
    private final List<CookingStep> listOfCookingSteps = new ArrayList<>();

    @Autowired
    public AddRecipeView(CategoryService categoryService, RecipeManagementService recipeManagementService) {
        this.categoryService = categoryService;
        this.recipeManagementService = recipeManagementService;

        initialize();
        addStyle();
    }

    private void initialize() {
        VerticalLayout recipeFormLayout = new VerticalLayout(uploadImage, recipeTitle, recipeDescription, categoryMultiselect, recipePreparingDuration, recipeCookingDuration);
        recipeFormLayout.addClassName("recipe-form");

        recipeFormLayout.add(ingredientUpload);
        add(recipeFormLayout);
    }

    public Recipe getRecipe() {
        Recipe recipeToBeSaved = new Recipe();
        recipeToBeSaved.setName(recipeTitle.getValue());
        recipeToBeSaved.setDescription(recipeDescription.getValue());
        recipeToBeSaved.setCategories(categoryMultiselect.getValue().stream().toList());
        recipeToBeSaved.setPreparingDuration(recipePreparingDuration.getValue());
        recipeToBeSaved.setCookingDuration(recipeCookingDuration.getValue());
        recipeToBeSaved.setIngredients(listOfIngredients);
        recipeToBeSaved.setCookingSteps(listOfCookingSteps);
        recipeToBeSaved.setComments(null);

        recipeToBeSaved.setDateCreated(LocalDate.now());

        return recipeToBeSaved;
    }

    private void addStyle() {
        recipeTitle.addClassName("dialog-field");
        recipeDescription.addClassName("dialog-field");

        categoryMultiselect.setItems(categoryService.getAllCategories());
        categoryMultiselect.setItemLabelGenerator(Category::getName);
        categoryMultiselect.setWidth("300px");

        setupDurationFields(recipePreparingDuration);
        setupDurationFields(recipeCookingDuration);
    }

    private void setupDurationFields(IntegerField field) {
        field.setMin(0);
        field.setValue(0);
        field.setStepButtonsVisible(true);
        field.setStep(5);

        Paragraph helperText = new Paragraph("Duration in minutes");
        helperText.getStyle().set("display", "inline");
        Div div = new Div(LumoIcon.CLOCK.create(), helperText);
        div.getStyle().set("display", "inline");
        field.setHelperComponent(div);
    }

}

package com.xenon.simplyrecipes.views.pages;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.MultiSelectComboBox;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoIcon;
import com.xenon.simplyrecipes.entities.Category;
import com.xenon.simplyrecipes.entities.Recipe;
import com.xenon.simplyrecipes.services.CategoryService;
import com.xenon.simplyrecipes.services.RecipeManagementService;
import com.xenon.simplyrecipes.views.MainLayout;
import com.xenon.simplyrecipes.views.components.CookingStepUploader;
import com.xenon.simplyrecipes.views.components.IngredientUploader;
import com.xenon.simplyrecipes.views.components.UploadImage;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;

/*
 * https://food52.com/recipes/new
 * */

@PageTitle("Add Recipe")
@Route(value = "/develop", layout = MainLayout.class)
public class AddRecipeView extends Main {

    private final CategoryService categoryService;
    private final RecipeManagementService recipeManagementService;

    private final Binder<Recipe> binder = new Binder<>(Recipe.class);

    private final UploadImage imageUploader = new UploadImage();
    private final TextField recipeTitle = new TextField("Recipe Title");
    private final TextArea recipeDescription = new TextArea("Description");
    private final MultiSelectComboBox<Category> categoryMultiselect = new MultiSelectComboBox<>("Categories");
    private final IntegerField recipePreparingDuration = new IntegerField("Preparation time");
    private final IntegerField recipeCookingDuration = new IntegerField("Cooking duration");
    private final IngredientUploader ingredientUploader = new IngredientUploader();
    private final CookingStepUploader cookingStepUploader = new CookingStepUploader();
    private final Button saveRecipeBtn = new Button("Save recipe");

    @Autowired
    public AddRecipeView(CategoryService categoryService, RecipeManagementService recipeManagementService) {
        this.categoryService = categoryService;
        this.recipeManagementService = recipeManagementService;

        initialize();
        addStyle();
        initBinder();
    }

    private void initialize() {
        H2 header = new H2("Add a New Recipe");
        header.addClassName("recipe-header");

        Div recipeFormLayout = new Div(header);
        recipeFormLayout.addClassName("recipe-form");
        recipeFormLayout.add(getFormFields().toArray(Component[]::new));
        recipeFormLayout.add(getFooter());

        add(recipeFormLayout);
    }

    private void addStyle() {
        recipeTitle.addClassName("dialog-field");
        recipeDescription.addClassName("dialog-field");

        recipeDescription.setHeight("100px");
        recipeCookingDuration.setWidth("300px");
        recipePreparingDuration.setWidth("300px");

        categoryMultiselect.setItems(categoryService.getAllCategories());
        categoryMultiselect.setItemLabelGenerator(Category::getName);
        categoryMultiselect.setWidth("300px");

        saveRecipeBtn.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_SUCCESS);
        saveRecipeBtn.setWidth("150px");

        setupDurationFields(recipePreparingDuration);
        setupDurationFields(recipeCookingDuration);
        setupSaveBtn();
        getFormFields().forEach(component -> component.addClassName("form-field"));
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

    public Recipe getRecipe() {
        Recipe recipeToBeSaved = new Recipe();
        recipeToBeSaved.setName(recipeTitle.getValue());
        recipeToBeSaved.setDescription(recipeDescription.getValue());
        recipeToBeSaved.setCategories(new HashSet<>(categoryMultiselect.getValue()));
        recipeToBeSaved.setPreparingDuration(recipePreparingDuration.getValue());
        recipeToBeSaved.setCookingDuration(recipeCookingDuration.getValue());
        recipeToBeSaved.setIngredients(ingredientUploader.getIngredientList());
        recipeToBeSaved.setCookingSteps(cookingStepUploader.getListOfCookingSteps());
        recipeToBeSaved.setComments(null);
        recipeToBeSaved.setDateCreated(LocalDate.now());

        return recipeToBeSaved;
    }

    private void setupSaveBtn() {
        saveRecipeBtn.addClickListener(e -> {
            if (!binder.isValid()) {
                binder.validate();
                showErrorNotification();
                return;
            }

            Recipe recipe = getRecipe();
            recipeManagementService.saveRecipe(recipe);
            UI.getCurrent().navigate(RecipeDetailsView.class, recipe.getId());
        });
    }

    private HorizontalLayout getFooter() {
        HorizontalLayout footer = new HorizontalLayout(saveRecipeBtn);
        footer.setJustifyContentMode(FlexComponent.JustifyContentMode.END);
        footer.getStyle().set("margin-top", "20px");
        return footer;
    }

    private List<Component> getFormFields() {
        return List.of(
                imageUploader,
                recipeTitle,
                recipeDescription,
                categoryMultiselect,
                recipePreparingDuration,
                recipeCookingDuration,
                ingredientUploader,
                cookingStepUploader
        );
    }

    private void initBinder() {
        binder.forField(recipeTitle)
                .asRequired("Please fill this field")
                .withValidator(s -> s.length() >= 4, "Name must contain at least 4 characters")
                .withValidator(s -> s.length() <= 30, "Name must contain less or equal to 30 characters")
                .bind(Recipe::getName, Recipe::setName);

        binder.forField(categoryMultiselect)
                .asRequired("Please select at least one category")
                .withValidator(list -> list.size() <= 5, "Please select up to 5 categories")
                .bind(Recipe::getCategories, Recipe::setCategories);

        binder.forField(recipeCookingDuration)
                .asRequired("Please fill this field")
                .withValidator(duration -> duration > 0, "Cooking duration must be greater than 0")
                .bind(Recipe::getCookingDuration, Recipe::setCookingDuration);
    }

    private void showErrorNotification() {
        Notification notification = Notification.show("An error occured while submiting form");
        notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
        notification.setPosition(Notification.Position.TOP_CENTER);
        notification.setDuration(5000);
        notification.open();
    }

}

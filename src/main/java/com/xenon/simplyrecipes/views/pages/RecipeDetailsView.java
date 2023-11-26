package com.xenon.simplyrecipes.views.pages;

import com.vaadin.flow.component.html.*;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.xenon.simplyrecipes.entities.Recipe;
import com.xenon.simplyrecipes.views.MainLayout;
import com.xenon.simplyrecipes.views.components.basic.HR;
import org.springframework.beans.factory.annotation.Autowired;

/*
 * https://food52.com/recipes/32626-new-england-spider-cake
 * */

@PageTitle("Recipe Details")
@Route(value = "recipe-details", layout = MainLayout.class)
public class RecipeDetailsView extends Main {

    private static final String FOLDER_LOCATION = "./images/";

    @Autowired
    private final Recipe recipe;

    public RecipeDetailsView(Recipe recipe) {
        this.recipe = recipe;

        initialize();
        costumize();
    }

    private void initialize() {
        add(
                getImage(),
                getDetailSection(),
                getIngredientSection()
        );
    }

    private void costumize() {

    }

    private Image getImage() {
        Image image = new Image();
        image.setSrc(FOLDER_LOCATION + recipe.getImageName());
        image.setAlt(recipe.getImageName());
        return new Image();
    }

    private UnorderedList getDetailSection() {
        UnorderedList detailsLayout = new UnorderedList();
        detailsLayout.addClassName("details-layout");

        detailsLayout.add(
                getDetailsLayout("PREP TIME", recipe.getPreparingDuration().toString()),
                getDetailsLayout("COOK TIME", recipe.getCookingDuration().toString())
        );

        return detailsLayout;
    }

    private ListItem getDetailsLayout(String title, String info) {
        ListItem layout = new ListItem(new Span(title));
        layout.setText(info + " minutes");
        return layout;
    }

    private Div getIngredientSection() {
        Div ingredientsLayout = new Div(new H3("Ingredients"), new HR());

        UnorderedList ul = new UnorderedList();
        recipe.getIngredients().forEach(ingredient -> {
            Paragraph name = new Paragraph(ingredient.getName() + " - ");
            Paragraph amount = new Paragraph(String.valueOf(ingredient.getAmount()));
            amount.getStyle().set("font-weight", "bold");

            ul.add(new ListItem(name, amount));
        });

        ingredientsLayout.add(ul);

        return ingredientsLayout;
    }

}

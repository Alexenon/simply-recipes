package com.xenon.simplyrecipes.views.pages;

import com.vaadin.flow.component.html.*;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.xenon.simplyrecipes.entities.Recipe;
import com.xenon.simplyrecipes.services.CommentService;
import com.xenon.simplyrecipes.services.RecipeService;
import com.xenon.simplyrecipes.services.UserService;
import com.xenon.simplyrecipes.views.MainLayout;
import com.xenon.simplyrecipes.views.components.CommentSection;
import com.xenon.simplyrecipes.views.components.basic.HR;
import org.springframework.beans.factory.annotation.Autowired;

/*
 * https://food52.com/recipes/32626-new-england-spider-cake
 * */

@PageTitle("Recipe Details")
@Route(value = "recipe-details", layout = MainLayout.class)
public class RecipeDetailsView extends Main implements HasUrlParameter<Long> {

    private static final String FOLDER_LOCATION = "./recipe-images/";

    @Autowired
    private RecipeService recipeService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private UserService userService;

    private Recipe recipe;

    @Override
    public void setParameter(BeforeEvent event, Long recipeId) {
        recipe = recipeService.getRecipeById(recipeId)
                .orElseThrow(() -> new RuntimeException("Recipe not found"));

        initialize();
        getElement().executeJs("window.scrollTo(0,0)"); // Scroll to top of the page, on initialization
    }

    private void initialize() {
        removeAll();
        addClassName("recipe-details");
        Div content = new Div();
        content.addClassName("recipe-details-content");
        content.add(
                getHeader(),
                getImage(),
                getDescription(),
                getInformationSection(),
                getIngredientSection(),
                getCookingStepSection(),
                getCommentSection()
        );
        add(content);
    }

    private H2 getHeader() {
        H2 header = new H2(recipe.getName());
        header.addClassName("recipe-header");
        return header;
    }

    private Div getDescription() {
        Paragraph description = new Paragraph(recipe.getDescription());
        Div container = new Div(description);
        container.addClassName("container");
        return container;
    }

    private Image getImage() {
        Image image = new Image();
        image.setSrc(FOLDER_LOCATION + recipe.getImageName());
        image.setAlt(recipe.getImageName());
        image.addClassName("recipe-image");
        return image;
    }

    private UnorderedList getInformationSection() {
        UnorderedList detailsLayout = new UnorderedList();
        detailsLayout.addClassName("details-layout");

        String mins = " minutes";
        detailsLayout.add(
                getListItem("PREP TIME", recipe.getPreparingDuration().toString() + mins),
                getListItem("COOK TIME", recipe.getCookingDuration().toString() + mins)
        );

        return detailsLayout;
    }

    private Div getIngredientSection() {
        Div ingredientsLayout = new Div(new H3("Ingredients"), new HR());
        ingredientsLayout.addClassName("ingredients-layout");

        UnorderedList ul = new UnorderedList();

        recipe.getIngredients().forEach(ingredient -> {
            String amount = String.valueOf(ingredient.getAmount());
            ListItem listItem = getListItem(ingredient.getName(), amount);
            ul.add(listItem);
        });

        ingredientsLayout.add(ul);

        return ingredientsLayout;
    }

    private Div getCookingStepSection() {
        Div layout = new Div(new H3("Cooking Steps"), new HR());
        layout.addClassName("cooking-steps-layout");

        OrderedList ol = new OrderedList();
        recipe.getCookingSteps().forEach(step -> {
            ListItem listItem = getListItem("", step.getStep());
            ol.add(listItem);
        });

        layout.add(ol);
        return layout;
    }

    private ListItem getListItem(String title, String info) {
        ListItem prepTimeLi = new ListItem(info);
        prepTimeLi.addComponentAsFirst(new Span(title));
        return prepTimeLi;
    }

    private CommentSection getCommentSection() {
        CommentSection commentSection = new CommentSection(recipe, commentService, userService);
        commentSection.addClassName("comment-section");
        return commentSection;
    }

}

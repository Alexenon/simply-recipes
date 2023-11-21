package com.xenon.simplyrecipes.views.components;

import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.xenon.simplyrecipes.entities.Ingredient;

public class IngredientLayout extends HorizontalLayout {

    private final Paragraph ingredientName;
    private final Paragraph ingredientAmount;
    private final Icon removeIcon = VaadinIcon.CLOSE_SMALL.create();

    public IngredientLayout(String ingredientName, int ingredientAmount) {
        this.ingredientName = new Paragraph(ingredientName);
        this.ingredientAmount = new Paragraph(String.valueOf(ingredientAmount));

        addClassName("ingredient-layout");
        addStyle();
        add(new Checkbox(), this.ingredientName, this.ingredientAmount, removeIcon);
    }

    private void addStyle() {
        setDefaultVerticalComponentAlignment(Alignment.CENTER);
        removeIcon.setColor("red");
        removeIcon.addClickListener(event -> this.removeFromParent());
    }

    public Ingredient getIngredient() {
        return null;
//            return new Ingredient(
//                    ingredientName.getText(),
//                    Integer.parseInt(ingredientAmount.getText())
//            );
    }
}
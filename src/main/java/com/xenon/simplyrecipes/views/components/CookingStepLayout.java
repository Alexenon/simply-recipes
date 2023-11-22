package com.xenon.simplyrecipes.views.components;

import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.xenon.simplyrecipes.entities.CookingStep;

public class CookingStepLayout extends HorizontalLayout {

    private final Paragraph stepName;
    private final Icon removeIcon = VaadinIcon.CLOSE_SMALL.create();

    public CookingStepLayout(String stepName) {
        this.stepName = new Paragraph(stepName);

        addClassName("ingredient-layout");
        addStyle();
        add(new Checkbox(), this.stepName, removeIcon);
    }

    private void addStyle() {
        setDefaultVerticalComponentAlignment(Alignment.CENTER);
        removeIcon.setColor("red");
        removeIcon.addClickListener(event -> this.removeFromParent());
    }

    public CookingStep getCookingStep() {
        CookingStep cookingStep = new CookingStep();
        cookingStep.setStep(stepName.getText());
        return cookingStep;
    }
}

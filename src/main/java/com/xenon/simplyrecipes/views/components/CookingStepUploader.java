package com.xenon.simplyrecipes.views.components;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.xenon.simplyrecipes.entities.CookingStep;

import java.util.ArrayList;
import java.util.List;

public class CookingStepUploader extends VerticalLayout {

    private static List<CookingStep> listOfCookingSteps;

    private final TextField cookingStepNameField = new TextField("Step name");
    private final Button addCookingStepBtn = new Button("+ Add cooking step");

    public CookingStepUploader() {
        listOfCookingSteps = new ArrayList<>();
        initialize();
        addStyle();
    }

    private void initialize() {
        HorizontalLayout layoutForFields = new HorizontalLayout(cookingStepNameField, addCookingStepBtn);
        layoutForFields.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
        add(layoutForFields);
    }

    private void addStyle() {
        cookingStepNameField.setHelperText("Example: Cut the onions into small pieces");
        cookingStepNameField.setRequired(true);
        cookingStepNameField.setMinLength(3);

        addCookingStepBtn.getStyle().set("margin-top", "-15px");
        addCookingStepBtn.addClickListener(e -> {
            if(cookingStepNameField.isEmpty()) return;

            CookingStepLayout cookingStepLayout = new CookingStepLayout(cookingStepNameField.getValue());
            add(cookingStepLayout);
            listOfCookingSteps.add(cookingStepLayout.getCookingStep());
            cookingStepNameField.clear();
        });
    }

    public List<CookingStep> getListOfCookingSteps() {
        return listOfCookingSteps;
    }


}

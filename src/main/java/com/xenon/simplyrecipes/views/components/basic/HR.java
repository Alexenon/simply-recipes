package com.xenon.simplyrecipes.views.components.basic;

import com.vaadin.flow.component.ClickNotifier;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HtmlContainer;
import com.vaadin.flow.component.Tag;

@Tag("hr")
public class HR extends HtmlContainer implements ClickNotifier<HR> {
    public HR() {
    }

    public HR(Component... components) {
        super(components);
    }

    public HR(String text) {
        this.setText(text);
    }
}

package com.example.application.views.main;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "",layout = MainView.class)
public class HomeView extends VerticalLayout {

    public HomeView() {
        add(new Label("Welcome!"));
    }
}

package com.example.application.views.main;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "",layout = MainView.class)
public class HomeView extends VerticalLayout {

    public HomeView() {
        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);

        add(new Label("Welcome! This is an application which " +
                "shows the top 100 movies taken from the iMDB database." +
                "You can see them if you go to the left drawer at the Movies tab, " +
                "or you can search for a movie you want!"));
    }
}

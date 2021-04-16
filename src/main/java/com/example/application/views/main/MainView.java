package com.example.application.views.main;

import java.util.HashMap;
import java.util.Map;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.router.Route;

import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.theme.lumo.Lumo;
import com.vaadin.flow.component.dependency.CssImport;


@PWA(name = "movie-review-app", shortName = "movie-review-app", enableInstallPrompt = false)
@JsModule("./styles/shared-styles.js")
@Theme(value = Lumo.class, variant = Lumo.DARK)
@CssImport("./views/main/main-view.css")

public class MainView extends AppLayout implements BeforeEnterObserver {
    private Tabs tabs = new Tabs();
    private Map<Class<? extends Component>, Tab> navigationTargetToTab = new HashMap<>();


    public MainView() {
        addMenuTab("Home",HomeView.class);
        addMenuTab("Movies", MovieView.class);
        tabs.setOrientation(Tabs.Orientation.VERTICAL);
        addToDrawer(tabs);
        addToNavbar(new DrawerToggle());

    }
    @Override
    public void beforeEnter(BeforeEnterEvent event) {
        tabs.setSelectedTab(navigationTargetToTab.get(event.getNavigationTarget()));
    }
    private void addMenuTab(String label, Class<? extends Component> target) {
        Tab tab = new Tab(new RouterLink(label, target));
        navigationTargetToTab.put(target, tab);
        tabs.add(tab);
    }



}

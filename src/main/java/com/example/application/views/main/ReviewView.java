package com.example.application.views.main;

import com.example.application.data.entity.MovieEntity;
import com.example.application.data.service.MovieService;
import com.example.application.data.service.ReviewService;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "/view/:id",layout = MainView.class)
public class ReviewView extends VerticalLayout implements BeforeEnterObserver {

    private String movieId;
    private MovieService movieService;
    private MovieEntity movie;

    public ReviewView(@Autowired MovieService movieService,
                      @Autowired ReviewService reviewService) {
        this.movieService = movieService;
    }


    @Override
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
        movieId = beforeEnterEvent.
                getRouteParameters().
                get("id").orElse("").
                replace("$","/");

        movie = movieService.getAll()
                .stream()
                .filter(mov -> mov.getId().equals(movieId))
                .findFirst().orElse(new MovieEntity());

        /*add(new Label( "Title: "+ movie.getTitle()));
        add(new Label("Author: "+movie.getAuthor()));
        add(new Label("Summary: " + movie.getPlot()));*/
    }
}

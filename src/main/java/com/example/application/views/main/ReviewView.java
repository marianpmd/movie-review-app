package com.example.application.views.main;

import com.example.application.data.entity.MovieEntity;
import com.example.application.data.service.MovieService;
import com.example.application.data.service.ReviewService;
import com.example.application.views.boxes.ReviewBox;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.details.Details;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "/view/:id",layout = MainView.class)
@CssImport("./views/main/review-block.css")
public class ReviewView extends VerticalLayout implements BeforeEnterObserver {

    private String movieId;
    private MovieService movieService;
    private MovieEntity movie;
    private ReviewService reviewService;

    public ReviewView(@Autowired MovieService movieService,
                      @Autowired ReviewService reviewService) {
        addClassName("review-view");
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);
        this.movieService = movieService;
        this.reviewService = reviewService;
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

        Image image = new Image();
        image.setSrc(movie.getImageURL());
        image.setAlt("alt");
        image.setWidth("330px");
        image.setHeight("330px");

        add(image);

        add(new Label( "Title: "+ movie.getTitle()));
        if (movie.getAuthor() != null) {
            add(new Label("Author: " + movie.getAuthor()));
        }
        add(new Label("Summary: " + movie.getPlot()));

        Details openReviews = new Details();
        openReviews.setSummaryText("Open Reviews");
        openReviews.setOpened(true);

        openReviews.addOpenedChangeListener(event ->{
            ReviewBox reviewBox = new ReviewBox(reviewService, movie, movieId);
            openReviews.setContent(reviewBox);
        });

        add(openReviews);
    }
}

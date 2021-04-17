package com.example.application.views.boxes;

import com.example.application.data.service.MovieService;
import com.example.application.views.main.ReviewView;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouteParameters;
import com.vaadin.flow.router.RouterLink;

import java.time.Duration;
import java.time.LocalTime;

@CssImport("./views/main/movie-block.css")
public class MovieBox extends VerticalLayout {

    public MovieBox(String id,String title ,Double rating, Integer duration, String movieURL) {
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);

        addClassName("movie-box");

        setSpacing(true);

        this.getElement().getStyle().set("border-color", "orange");
        this.getElement().getStyle().set("border-radius", "5px");
        this.getElement().getStyle().set("border-style", "solid");
        Image moviePic = new Image(movieURL,"alt");
        moviePic.setHeight("250px");
        moviePic.setWidth("250px");

        Label titleLabel = new Label(title);
        titleLabel.getElement().getStyle().set("margin","9px");
        Label durationLabel = new Label();
        add(moviePic,titleLabel);

        if (duration != null){
            String time = LocalTime.MIN.plus(Duration.ofMinutes(duration)).toString();
            durationLabel = new Label("Time: "+time);
            add(durationLabel);
        }

        Label ratingLabel = new Label();
        if (rating != null){
            ratingLabel = new Label("Rating : " + rating);
            add(ratingLabel);
        }

        durationLabel.getElement().getStyle().set("margin","10px");
        add(durationLabel);
        String sendableId = id.replace("/","$");

        this.addClickListener(event ->{
            UI.getCurrent().navigate(ReviewView.class,new RouteParameters("id",sendableId));
        });

    }

}

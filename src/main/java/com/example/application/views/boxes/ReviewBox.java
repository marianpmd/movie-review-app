package com.example.application.views.boxes;

import com.example.application.data.entity.MovieEntity;
import com.example.application.data.entity.ReviewEntity;
import com.example.application.data.service.ReviewService;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;

import java.sql.Time;
import java.time.LocalTime;
import java.util.List;

public class ReviewBox extends VerticalLayout {


    public ReviewBox(ReviewService reviewService,MovieEntity movie, String id) {
        setSizeFull();
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);

        TextField author = new TextField();
        author.setPlaceholder("Author ... ");
        author.setMinLength(5);

        Binder<ReviewEntity> binder = new Binder<>(ReviewEntity.class);
        binder.forField(author)
                .withValidator(min -> min.length() >= 5, "Minimum length is 5")
                .bind(ReviewEntity::getAuthor,ReviewEntity::setAuthor);


        TextArea textArea = new TextArea();
        textArea.setMaxLength(250);
        textArea.setMinLength(1);
        textArea.setPlaceholder("Your Review ... ");
        binder.forField(textArea)
                .withValidator(min -> min.length() >= 1, "Please provide a review.")
                .withValidator(max -> max.length() <= 250, "Maximum number of characters is 250.")
                .bind(ReviewEntity::getAuthor,ReviewEntity::setAuthor);

        Button postButton = new Button("Post Review");

        postButton.addClickListener(event -> {
            if (author.isInvalid() || textArea.isInvalid()){
                System.out.println("Invalid input");
            }else {
                System.out.println(author.getValue() + " " + textArea.getValue());
                ReviewEntity review = new ReviewEntity(movie,author.getValue(), textArea.getValue(), Time.valueOf(LocalTime.now()));
                reviewService.save(review);
                UI.getCurrent().getPage().reload();
            }
        });
        add(author, textArea, postButton);

        List<ReviewEntity> allByMovieId = reviewService.findAllByMovieId(id);
        for (ReviewEntity review : allByMovieId) {
            add(new ReviewBubble(review));
        }

    }
}

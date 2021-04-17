package com.example.application.views.boxes;

import com.example.application.data.entity.ReviewEntity;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;


@CssImport("./views/main/review-bubble.css")
public class ReviewBubble extends VerticalLayout {

    public ReviewBubble(ReviewEntity review) {

        addClassName("bubble");
        setSizeFull();
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);

        Label authorAndTimeStamp;

        if (review.getTime() != null){
            authorAndTimeStamp = new Label("Author: " + review.getAuthor() + " at " + review.getTime().toString());
        }else {
            authorAndTimeStamp = new Label(review.getAuthor());
        }

        Label text = new Label(review.getText());
        text.getElement().getStyle().set("border-color-top","orange");
        text.getElement().getStyle().set("border-style","solid");
        add(authorAndTimeStamp,text);


    }
}

package com.example.application.views.main;

import com.example.application.data.entity.MovieEntity;
import com.example.application.data.service.MovieService;
import com.example.application.views.boxes.MovieBox;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Route(value = "movies",layout= MainView.class)
public class MovieView extends VerticalLayout {

    private int colCount;

    public MovieView(@Autowired MovieService movieService) {
        setSizeFull();
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        List<MovieEntity> movies = movieService.getAll();
        HorizontalLayout row = createCustomRow();
        row.getElement().getStyle().set("padding-left","10px");
        for (int i = 0; i < movies.size(); i++) {

            row.add(new MovieBox(movies.get(i).getId()
                    ,movies.get(i).getTitle()
                    ,movies.get(i).getMinutes()
                    ,movies.get(i).getImageURL()));
            colCount++;
            if (colCount % 4 == 0 && colCount!=0){
                add(row);
                row = createCustomRow();
            }
            if (movies.size() - colCount < 4){
                add(row);
            }

        }

    }

    private HorizontalLayout createCustomRow() {
        HorizontalLayout row = new HorizontalLayout();
        row.setSpacing(true);
        row.setPadding(true);
        row.setMargin(true);

        row.getElement().getStyle().set("border-color","252, 136, 3");
        row.getElement().getStyle().set("border-radius","7px");

        return row;

    }
}

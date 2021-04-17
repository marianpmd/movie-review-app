package com.example.application.views.main;

import com.example.application.data.entity.MovieEntity;
import com.example.application.data.service.MovieService;
import com.example.application.views.boxes.MovieBox;
import com.vaadin.flow.component.ItemLabelGenerator;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteParameters;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Route(value = "movies",layout= MainView.class)
public class MovieView extends FlexLayout {


    public MovieView(@Autowired MovieService movieService) {
        setSizeFull();
        setFlexDirection(FlexDirection.COLUMN);

        ComboBox<MovieEntity> comboBox = new ComboBox<>();

        List<MovieEntity> movies = movieService.getAll();

        comboBox.setItems(movies);
        comboBox.setItemLabelGenerator((ItemLabelGenerator<MovieEntity>) MovieEntity::getTitle);
        comboBox.setPlaceholder("Search for a movie ... ");

        comboBox.addValueChangeListener(event ->{
            String sendableId = event.getValue().getId();
            sendableId = sendableId.replace("/","$");
            UI.getCurrent().navigate(ReviewView.class,new RouteParameters("id",sendableId));
        });

        add(comboBox);

        for (MovieEntity movie : movies) {

            add(new MovieBox(movie.getId()
                    , movie.getTitle()
                    , movie.getRating()
                    , movie.getMinutes()
                    , movie.getImageURL()));
        }

    }

}

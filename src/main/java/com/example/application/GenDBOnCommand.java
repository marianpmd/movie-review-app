package com.example.application;

import ch.qos.logback.core.encoder.EchoEncoder;
import com.example.application.data.api.request.*;
import com.example.application.data.api.request.api.APIData;
import com.example.application.data.entity.MovieEntity;
import com.example.application.data.entity.ReviewEntity;
import com.example.application.data.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import org.springframework.stereotype.Component;

import javax.swing.text.html.Option;
import java.sql.Time;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Component
public class GenDBOnCommand implements CommandLineRunner {
    private APIData data;
    private MovieRepository repository;

    public GenDBOnCommand(@Autowired MovieRepository repository,
                          @Autowired APIData data ) {
        this.repository = repository;
        this.data = data;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Want to recreate the database ? y/n : ");
        String result = scanner.nextLine();

        switch (result){

            case "y":
                data.init();
                List<Movie> movies = data.getMovies();
                for (Movie movie: movies) {
                    MovieEntity movieEntity;
                    try{
                       movieEntity = createMovieEntity(Optional.of(movie));
                    }catch (Exception e){
                        continue;
                    }
                    repository.save(movieEntity);
                    System.out.println("saved : " + movieEntity.getTitle());

                }
                break;
            default:
                break;
        }
    }

    private MovieEntity createMovieEntity(Optional<Movie> movieOptional) throws Exception{
        Movie movie = movieOptional.orElse(new Movie());

        String id = movie.getId();

        Optional<Title> titleOptional = Optional.ofNullable(movie.getTitle());
        Optional<Ratings> ratingsOptional = Optional.ofNullable(movie.getRatings());
        Optional<PlotSummary> summaryOptional = Optional.ofNullable(movie.getPlotSummary());
        Optional<Image> imageOptional = Optional.ofNullable(titleOptional.orElse(new Title()).getImage());

        String title = titleOptional.orElse(new Title()).getTitle();
        Integer minutes = titleOptional.orElse(new Title()).getRunningTimeInMinutes();
        Integer year = titleOptional.orElse(new Title()).getYear();
        Double rating = ratingsOptional.orElse(new Ratings()).getRating();
        Integer ratingCount = ratingsOptional.orElse(new Ratings()).getRatingCount();
        String url = imageOptional.orElse(new Image()).getUrl();
        String author = summaryOptional.orElse(new PlotSummary()).getAuthor();
        String text = summaryOptional.orElse(new PlotSummary()).getText();

        return new MovieEntity(id,title,minutes,year,rating,ratingCount,url,author,text);
    }
}

package com.example.application.data.api.request.api;

import com.example.application.data.api.request.Movie;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@Component
public class APIData {
    private List<Movie> movies = new ArrayList<>();

    public void init() throws UnirestException, JsonProcessingException {

        JSONArray response = Unirest.get("https://imdb8.p.rapidapi.com/title/get-most-popular-movies")
                .header("x-rapidapi-key", "")
                .header("x-rapidapi-host", "imdb8.p.rapidapi.com")
                .asJson()
                .getBody()
                .getArray();

        System.out.println(response +  "and size : " + response.length());


        for (int i = 0; i < response.length(); i++) {

            HttpResponse<String> responseMovie = Unirest.get("https://imdb8.p.rapidapi.com/title/get-overview-details?tconst="+response.getString(i).replace("/title/",""))
                    .header("x-rapidapi-key", "")
                    .header("x-rapidapi-host", "imdb8.p.rapidapi.com")
                    .asString();

            System.out.println(responseMovie.getBody());
            ObjectMapper objectMapper = new ObjectMapper();
            Movie movie = objectMapper.readValue(responseMovie.getBody(),Movie.class);
            movies.add(movie);

        }



    }

    public List<Movie> getMovies() {
        return movies;
    }
}

package com.example.application.data.entity;

import org.springframework.context.annotation.ComponentScan;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

@Entity
@Table(name = "movie")
public class MovieEntity  {
    @Id
    private String id;
    @Column(length = 2048)
    private String title;

    private Integer minutes;
    private Integer year;

    private Double rating;

    private Integer ratingCount;
    @Column(length = 2048)
    private String imageURL;
    @Column(length = 2048)
    private String author;
    @Column(length = 4096)
    private String plot;

    @OneToMany(mappedBy = "movie",fetch = FetchType.EAGER)
    private List<ReviewEntity> reviews;


    public MovieEntity(String id,String title, Integer minutes, Integer year, Double rating, Integer ratingCount, String imageURL, String author, String plot, List<ReviewEntity> reviews) {
        this.title = title;
        this.minutes = minutes;
        this.year = year;
        this.rating = rating;
        this.ratingCount = ratingCount;
        this.imageURL = imageURL;
        this.author = author;
        this.plot = plot;
        this.reviews = reviews;
        this.id = id;
    }
    public MovieEntity(String id,String title, Integer minutes, Integer year, Double rating, Integer ratingCount, String imageURL, String author, String plot) {
        this.title = title;
        this.minutes = minutes;
        this.year = year;
        this.rating = rating;
        this.ratingCount = ratingCount;
        this.imageURL = imageURL;
        this.author = author;
        this.plot = plot;
        this.id = id;
    }

    public MovieEntity() {
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getMinutes() {
        return minutes;
    }

    public void setMinutes(Integer minutes) {
        this.minutes = minutes;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Integer getRatingCount() {
        return ratingCount;
    }

    public void setRatingCount(Integer ratingCount) {
        this.ratingCount = ratingCount;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public List<ReviewEntity> getReviews() {
        return reviews;
    }

    public void setReviews(List<ReviewEntity> reviews) {
        this.reviews = reviews;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}


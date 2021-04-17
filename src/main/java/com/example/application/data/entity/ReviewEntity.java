package com.example.application.data.entity;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "review")
public class ReviewEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "movie_id")
    private MovieEntity movie;
    @Column(length = 2048)
    private String author;
    @Column(length = 2048)
    private String text;
    @Column(length = 2048)
    private Time time;


    public ReviewEntity(MovieEntity movie, String author, String text, Time time) {
        this.movie = movie;
        this.author = author;
        this.text = text;
        this.time = time;

    }

    public ReviewEntity(String author, String text, Time time) {
        this.author = author;
        this.text = text;
        this.time = time;
    }

    public ReviewEntity(Integer id, MovieEntity movie, String author, String text, Time time) {
        this.movie = movie;
        this.author = author;
        this.text = text;
        this.time = time;
        this.id = id;
    }

    public ReviewEntity() {
    }

    public MovieEntity getMovie() {
        return movie;
    }

    public void setMovie(MovieEntity movie) {
        this.movie = movie;
    }


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}

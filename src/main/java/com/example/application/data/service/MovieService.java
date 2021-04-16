package com.example.application.data.service;

import com.example.application.data.entity.MovieEntity;
import com.example.application.data.entity.ReviewEntity;
import com.example.application.data.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    private MovieRepository repo;

    public List<MovieEntity> getAll(){
        return repo.findAll();
    }

    public void updateReviewDataById(List<ReviewEntity> reviewEntities , String id){
        MovieEntity movieEntity = repo.findById(id).orElseThrow();
        movieEntity.setReviews(reviewEntities);
        repo.save(movieEntity);
    }

    public void save(MovieEntity movieEntity) {
        repo.save(movieEntity);
    }

    public void flush(){
        repo.flush();
    }
}

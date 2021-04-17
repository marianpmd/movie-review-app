package com.example.application.data.service;

import com.example.application.data.entity.ReviewEntity;
import com.example.application.data.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository repo;

    public void save(ReviewEntity reviewEntity){
        repo.save(reviewEntity);
    }

    public List<ReviewEntity> findAllByMovieId(String movieId){
        return repo.findAllByMovie_Id(movieId);
    }
}

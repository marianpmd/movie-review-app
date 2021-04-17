package com.example.application.data.repository;

import com.example.application.data.entity.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<ReviewEntity,Integer> {

    List<ReviewEntity> findAllByMovie_Id(String movie_id);
}

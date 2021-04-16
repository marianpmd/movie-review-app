package com.example.application.data.repository;

import com.example.application.data.entity.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<ReviewEntity,Integer> {
}

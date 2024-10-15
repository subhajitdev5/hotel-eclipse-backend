package com.example.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hotel.model.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {

}

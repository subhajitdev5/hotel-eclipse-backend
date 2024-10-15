package com.example.hotel.service;

import com.example.hotel.model.Feedback;
import com.example.hotel.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    // Method to save feedback
    public Feedback saveFeedback(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    // Method to get all feedback entries
    public List<Feedback> getAllFeedback() {
        return feedbackRepository.findAll();
    }

    // Method to get feedback by ID (optional, if needed)
    public Feedback getFeedbackById(Long id) {
        return feedbackRepository.findById(id).orElse(null);
    }
}

package com.example.hotel.controller;

import com.example.hotel.model.Feedback;
import com.example.hotel.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/feedback")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @PostMapping
    public ResponseEntity<String> saveFeedback(@RequestBody Feedback feedback) {
        feedbackService.saveFeedback(feedback);
        return ResponseEntity.ok("Feedback submitted successfully");
    }

    @GetMapping
    public ResponseEntity<?> getAllFeedback() {
        return ResponseEntity.ok(feedbackService.getAllFeedback());
    }
}

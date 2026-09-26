package com.example.healthcare.Service;

import com.example.healthcare.model.TriageRequest;
import org.springframework.stereotype.Service;

@Service
public class triageservice {

    public String calculatePriority(TriageRequest request) {

        int score = 0;

        if (request.isChestPain()) {
            score += 5;
        }

        if (request.isBreathingDifficulty()) {
            score += 5;
        }

        if (request.isSevereBleeding()) {
            score += 5;
        }

        if (request.isHighFever()) {
            score += 3;
        }

        if (request.isHighBP()) {
            score += 3;
        }

        if (request.getAge() > 60) {
            score += 2;
        }

        if (score >= 8) {
            return "CRITICAL";
        } else if (score >= 5) {
            return "HIGH";
        } else if (score >= 3) {
            return "MEDIUM";
        } else {
            return "LOW";
        }
    }
}
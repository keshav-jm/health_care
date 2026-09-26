package com.example.healthcare.controller;

import com.example.healthcare.model.Consultation;
import com.example.healthcare.model.TriageResponse;
import com.example.healthcare.Repository.ConsultationRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/triage")
public class TriageController {

    private final ConsultationRepository consultationRepository;

    public TriageController(ConsultationRepository consultationRepository) {
        this.consultationRepository = consultationRepository;
    }

    @PostMapping
    public TriageResponse calculateTriage(
            @RequestBody Consultation consultation) {

        int score = 0;

        // Chest pain
        if (consultation.isChestPain()) {
            score += 5;
        }

        // Breathing difficulty
        if (consultation.isBreathingDifficulty()) {
            score += 5;
        }

        // Severe bleeding
        if (consultation.isSevereBleeding()) {
            score += 5;
        }

        // High fever
        if (consultation.isHighFever()) {
            score += 3;
        }

        // High blood pressure
        if (consultation.isHighBloodPressure()) {
            score += 3;
        }

        // Age above 60
        if (consultation.getAge() > 60) {
            score += 2;
        }


        // Determine priority
        String priority;
        String message;

        if (score >= 8) {

            priority = "CRITICAL";
            message = "Immediate medical attention required";

        } else if (score >= 5) {

            priority = "HIGH";
            message = "Prompt medical attention recommended";

        } else if (score >= 3) {

            priority = "MEDIUM";
            message = "Medical evaluation recommended";

        } else {

            priority = "LOW";
            message = "Routine medical evaluation";
        }


        // Save triage result
        consultation.setTriageScore(score);
        consultation.setPriority(priority);

        // Set default status if not provided
        if (consultation.getStatus() == null ||
                consultation.getStatus().isEmpty()) {

            consultation.setStatus("PENDING");
        }

        Consultation savedConsultation =
                consultationRepository.save(consultation);


        // Return response
        return new TriageResponse(
                savedConsultation.getPatientId(),
                score,
                priority,
                message
        );
    }
}
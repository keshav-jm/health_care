package com.example.healthcare.model;

public class TriageResponse {

    private Long patientId;
    private int score;
    private String priority;
    private String message;

    public TriageResponse(Long patientId, int score, String priority, String message) {
        this.patientId = patientId;
        this.score = score;
        this.priority = priority;
        this.message = message;
    }

    public Long getPatientId() {
        return patientId;
    }

    public int getScore() {
        return score;
    }

    public String getPriority() {
        return priority;
    }

    public String getMessage() {
        return message;
    }
}
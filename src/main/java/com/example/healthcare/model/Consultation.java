package com.example.healthcare.model;

import jakarta.persistence.*;

@Entity
@Table(name = "consultations")
public class Consultation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "doctor_id")
    private Long doctorId;

    @Column(name = "patient_id")
    private Long patientId;

    private String status;
    private String symptoms;
    private int age;

    @Column(name = "breathing_difficulty")
    private boolean breathingDifficulty;

    @Column(name = "chest_pain")
    private boolean chestPain;

    @Column(name = "high_blood_pressure")
    private boolean highBloodPressure;

    @Column(name = "high_fever")
    private boolean highFever;

    @Column(name = "severe_bleeding")
    private boolean severeBleeding;

    private String priority;

    @Column(name = "triage_score")
    private int triageScore;

    public Consultation() {
    }

    public Long getId() {
        return id;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isBreathingDifficulty() {
        return breathingDifficulty;
    }

    public void setBreathingDifficulty(boolean breathingDifficulty) {
        this.breathingDifficulty = breathingDifficulty;
    }

    public boolean isChestPain() {
        return chestPain;
    }

    public void setChestPain(boolean chestPain) {
        this.chestPain = chestPain;
    }

    public boolean isHighBloodPressure() {
        return highBloodPressure;
    }

    public void setHighBloodPressure(boolean highBloodPressure) {
        this.highBloodPressure = highBloodPressure;
    }

    public boolean isHighFever() {
        return highFever;
    }

    public void setHighFever(boolean highFever) {
        this.highFever = highFever;
    }

    public boolean isSevereBleeding() {
        return severeBleeding;
    }

    public void setSevereBleeding(boolean severeBleeding) {
        this.severeBleeding = severeBleeding;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public int getTriageScore() {
        return triageScore;
    }

    public void setTriageScore(int triageScore) {
        this.triageScore = triageScore;
    }
}
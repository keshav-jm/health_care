package com.example.healthcare.model;

public class TriageRequest {

    private Long patientId;

    private boolean chestPain;
    private boolean breathingDifficulty;
    private boolean severeBleeding;
    private boolean highFever;
    private boolean highBP;

    private int age;

    public TriageRequest() {
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public boolean isChestPain() {
        return chestPain;
    }

    public void setChestPain(boolean chestPain) {
        this.chestPain = chestPain;
    }

    public boolean isBreathingDifficulty() {
        return breathingDifficulty;
    }

    public void setBreathingDifficulty(boolean breathingDifficulty) {
        this.breathingDifficulty = breathingDifficulty;
    }

    public boolean isSevereBleeding() {
        return severeBleeding;
    }

    public void setSevereBleeding(boolean severeBleeding) {
        this.severeBleeding = severeBleeding;
    }

    public boolean isHighFever() {
        return highFever;
    }

    public void setHighFever(boolean highFever) {
        this.highFever = highFever;
    }

    public boolean isHighBP() {
        return highBP;
    }

    public void setHighBP(boolean highBP) {
        this.highBP = highBP;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
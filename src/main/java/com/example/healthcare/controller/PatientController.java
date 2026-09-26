package com.example.healthcare.controller;

import com.example.healthcare.Repository.PatientRepository;
import com.example.healthcare.model.Patient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/patients")
public class PatientController {

    private final PatientRepository patientRepository;

    public PatientController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    // Save or update patient cleanly
    @PostMapping
    public ResponseEntity<Patient> createOrUpdatePatient(@RequestBody Patient patient) {
        // If ID is provided and already exists, update the existing record
        if (patient.getId() != null) {
            Optional<Patient> existingPatient = patientRepository.findById(patient.getId());
            if (existingPatient.isPresent()) {
                Patient p = existingPatient.get();
                p.setName(patient.getName());
                p.setUhid(patient.getUhid());
                p.setAge(patient.getAge());
                p.setGender(patient.getGender());
                p.setPhone(patient.getPhone());
                return ResponseEntity.ok(patientRepository.save(p));
            }
        }

        // Otherwise save as a new patient record
        Patient savedPatient = patientRepository.save(patient);
        return ResponseEntity.ok(savedPatient);
    }

    @GetMapping
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable Long id) {
        return patientRepository.findById(id).orElse(null);
    }
}
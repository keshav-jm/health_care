package com.example.healthcare.controller;

import com.example.healthcare.Repository.DoctorRepository;
import com.example.healthcare.model.Doctor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    private final DoctorRepository doctorRepository;

    public DoctorController(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    // GET all doctors
    @GetMapping
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    // GET doctor by ID
    @GetMapping("/{id}")
    public Doctor getDoctorById(@PathVariable Long id) {
        return doctorRepository.findById(id).orElse(null);
    }

    // CREATE or UPDATE doctor
    @PostMapping
    public ResponseEntity<Doctor> createOrUpdateDoctor(@RequestBody Doctor doctor) {
        if (doctor.getId() != null) {
            Doctor existing = doctorRepository.findById(doctor.getId()).orElse(null);
            if (existing != null) {
                existing.setName(doctor.getName());
                existing.setSpecialization(doctor.getSpecialization());
                return ResponseEntity.ok(doctorRepository.save(existing));
            }
        }
        Doctor savedDoctor = doctorRepository.save(doctor);
        return ResponseEntity.ok(savedDoctor);
    }
}
package com.example.healthcare.controller;

import com.example.healthcare.Repository.ConsultationRepository;
import com.example.healthcare.Repository.DoctorRepository;
import com.example.healthcare.model.Consultation;
import com.example.healthcare.model.Doctor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/consultations")
public class ConsultationController {

    private final ConsultationRepository consultationRepository;
    private final DoctorRepository doctorRepository;

    public ConsultationController(
            ConsultationRepository consultationRepository,
            DoctorRepository doctorRepository) {

        this.consultationRepository = consultationRepository;
        this.doctorRepository = doctorRepository;
    }

    // CREATE consultation (Fixes the form submission)
    @PostMapping
    public Consultation createConsultation(@RequestBody Consultation consultation) {
        if (consultation.getStatus() == null || consultation.getStatus().trim().isEmpty()) {
            consultation.setStatus("PENDING");
        }

        // Basic rule-based triage assessment
        consultation.setPriority("NORMAL");

        return consultationRepository.save(consultation);
    }

    // Get all consultations
    @GetMapping
    public List<Consultation> getConsultations() {
        return consultationRepository.findAll();
    }

    // Get consultation by ID
    @GetMapping("/{id}")
    public Consultation getConsultation(@PathVariable Long id) {
        return consultationRepository.findById(id).orElse(null);
    }

    // Assign doctor to consultation
    @PutMapping("/{consultationId}/assign/{doctorId}")
    public Consultation assignDoctor(
            @PathVariable Long consultationId,
            @PathVariable Long doctorId) {

        Consultation consultation =
                consultationRepository.findById(consultationId).orElse(null);

        if (consultation == null) {
            return null;
        }

        Doctor doctor =
                doctorRepository.findById(doctorId).orElse(null);

        if (doctor == null) {
            return null;
        }

        consultation.setDoctorId(doctor.getId());
        consultation.setStatus("ASSIGNED");

        return consultationRepository.save(consultation);
    }
}
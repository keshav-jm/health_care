package com.example.healthcare.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "invoices")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("invoiceId")
    @Column(name = "invoice_id")
    private String invoiceId;

    @JsonProperty("patientId")
    @Column(name = "patient_id")
    private String patientId;

    @JsonProperty("consultationId")
    @Column(name = "consultation_id")
    private String consultationId;

    private String service;

    private Double amount;

    private String status;

    public Invoice() {
    }

    public Invoice(Long id, String invoiceId, String patientId, String consultationId, String service, Double amount, String status) {
        this.id = id;
        this.invoiceId = invoiceId;
        this.patientId = patientId;
        this.consultationId = consultationId;
        this.service = service;
        this.amount = amount;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getConsultationId() {
        return consultationId;
    }

    public void setConsultationId(String consultationId) {
        this.consultationId = consultationId;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
package com.example.healthcare.Service;

import com.example.healthcare.Repository.InvoiceRepository;
import com.example.healthcare.model.Invoice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;

    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public Invoice createInvoice(Invoice invoice) {
        // 1. Set default status to UNPAID if missing
        if (invoice.getStatus() == null || invoice.getStatus().trim().isEmpty()) {
            invoice.setStatus("UNPAID");
        }

        // 2. Generate custom invoiceId if not provided in request body
        if (invoice.getInvoiceId() == null || invoice.getInvoiceId().trim().isEmpty()) {
            long nextId = invoiceRepository.count() + 1;
            invoice.setInvoiceId("INV-" + (1000 + nextId));
        }

        // 3. Save to MySQL and return the saved entity
        return invoiceRepository.save(invoice);
    }

    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }

    public Invoice getInvoiceById(Long id) {
        return invoiceRepository.findById(id).orElse(null);
    }

    public Invoice getInvoiceByInvoiceId(String invoiceId) {
        return invoiceRepository.findByInvoiceId(invoiceId).orElse(null);
    }
}
package com.example.healthcare.Service;

import com.example.healthcare.Repository.InvoiceRepository;
import com.example.healthcare.Repository.PaymentRepository;
import com.example.healthcare.model.Invoice;
import com.example.healthcare.model.Payment;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final InvoiceRepository invoiceRepository;

    public PaymentService(PaymentRepository paymentRepository, InvoiceRepository invoiceRepository) {
        this.paymentRepository = paymentRepository;
        this.invoiceRepository = invoiceRepository;
    }

    public Payment processPayment(Payment payment) {
        // 1. Set payment status to SUCCESS
        payment.setStatus("SUCCESS");

        // 2. Save the payment in the payments table
        Payment savedPayment = paymentRepository.save(payment);

        // 3. Find the matching invoice using String invoiceId and update its status to PAID
        if (payment.getInvoiceId() != null) {
            Optional<Invoice> optionalInvoice = invoiceRepository.findByInvoiceId(payment.getInvoiceId());
            if (optionalInvoice.isPresent()) {
                Invoice invoice = optionalInvoice.get();
                invoice.setStatus("PAID");
                invoiceRepository.save(invoice);
            }
        }

        return savedPayment;
    }

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }
}
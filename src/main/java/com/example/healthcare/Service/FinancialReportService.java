package com.example.healthcare.Service;

import com.example.healthcare.Repository.BudgetRepository;
import com.example.healthcare.Repository.InvoiceRepository;
import com.example.healthcare.Repository.PurchaseOrderRepository;
import com.example.healthcare.model.Budget;
import com.example.healthcare.model.Invoice;
import com.example.healthcare.model.ProfitAndLossReport;
import com.example.healthcare.model.PurchaseOrder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinancialReportService {

    private final InvoiceRepository invoiceRepository;
    private final PurchaseOrderRepository purchaseOrderRepository;
    private final BudgetRepository budgetRepository;

    public FinancialReportService(InvoiceRepository invoiceRepository,
                                  PurchaseOrderRepository purchaseOrderRepository,
                                  BudgetRepository budgetRepository) {
        this.invoiceRepository = invoiceRepository;
        this.purchaseOrderRepository = purchaseOrderRepository;
        this.budgetRepository = budgetRepository;
    }

    public ProfitAndLossReport generateProfitAndLossReport() {
        List<Invoice> invoices = invoiceRepository.findAll();
        List<PurchaseOrder> purchaseOrders = purchaseOrderRepository.findAll();

        double totalIncome = invoices.stream()
                .filter(i -> "PAID".equalsIgnoreCase(i.getStatus()))
                .mapToDouble(Invoice::getAmount)
                .sum();

        double totalExpenses = purchaseOrders.stream()
                .mapToDouble(PurchaseOrder::getAmount)
                .sum();

        double netBalance = totalIncome - totalExpenses;

        return new ProfitAndLossReport(totalIncome, totalExpenses, netBalance);
    }

    public List<Budget> getBudgetReport() {
        return budgetRepository.findAll();
    }
}
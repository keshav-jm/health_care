package com.example.healthcare.controller;

import com.example.healthcare.Service.FinancialReportService;
import com.example.healthcare.model.Budget;
import com.example.healthcare.model.ProfitAndLossReport;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/reports")
public class FinancialReportController {

    private final FinancialReportService financialReportService;

    public FinancialReportController(FinancialReportService financialReportService) {
        this.financialReportService = financialReportService;
    }

    @GetMapping("/profit-and-loss")
    public ProfitAndLossReport getProfitAndLossReport() {
        return financialReportService.generateProfitAndLossReport();
    }

    @GetMapping("/budget-summary")
    public List<Budget> getBudgetReport() {
        return financialReportService.getBudgetReport();
    }
}
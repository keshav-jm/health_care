package com.example.healthcare.controller;

import com.example.healthcare.Service.BudgetService;
import com.example.healthcare.model.Budget;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/budgets")
public class BudgetController {

    private final BudgetService budgetService;

    public BudgetController(BudgetService budgetService) {
        this.budgetService = budgetService;
    }

    @PostMapping
    public Budget createOrUpdateBudget(@RequestBody Budget budget) {
        return budgetService.saveBudget(budget);
    }

    @GetMapping
    public List<Budget> getAllBudgets() {
        return budgetService.getAllBudgets();
    }

    @GetMapping("/{department}")
    public Budget getBudgetByDepartment(@PathVariable String department) {
        return budgetService.getBudgetByDepartment(department);
    }
}
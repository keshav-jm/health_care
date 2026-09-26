
package com.example.healthcare.Service;

import com.example.healthcare.Repository.BudgetRepository;
import com.example.healthcare.model.Budget;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BudgetService {

    private final BudgetRepository budgetRepository;

    public BudgetService(BudgetRepository budgetRepository) {
        this.budgetRepository = budgetRepository;
    }

    public Budget saveBudget(Budget budget) {
        if (budget.getAllocatedAmount() == null) {
            budget.setAllocatedAmount(0.0);
        }
        if (budget.getSpentAmount() == null) {
            budget.setSpentAmount(0.0);
        }

        // Calculate remaining amount
        budget.setRemainingAmount(budget.getAllocatedAmount() - budget.getSpentAmount());

        return budgetRepository.save(budget);
    }

    public List<Budget> getAllBudgets() {
        return budgetRepository.findAll();
    }

    public Budget getBudgetByDepartment(String department) {
        return budgetRepository.findByDepartment(department).orElse(null);
    }
}
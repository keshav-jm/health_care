package com.example.healthcare.Repository;

import com.example.healthcare.model.Budget;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BudgetRepository extends JpaRepository<Budget, Long> {

    // Helper method to find budget by department name
    Optional<Budget> findByDepartment(String department);
}
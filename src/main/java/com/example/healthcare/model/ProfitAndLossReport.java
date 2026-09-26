package com.example.healthcare.model;

public class ProfitAndLossReport {

    private Double totalClinicalIncome;
    private Double totalSupplyExpenses;
    private Double netProfitOrLoss;

    public ProfitAndLossReport() {
    }

    public ProfitAndLossReport(Double totalClinicalIncome, Double totalSupplyExpenses, Double netProfitOrLoss) {
        this.totalClinicalIncome = totalClinicalIncome;
        this.totalSupplyExpenses = totalSupplyExpenses;
        this.netProfitOrLoss = netProfitOrLoss;
    }

    public Double getTotalClinicalIncome() {
        return totalClinicalIncome;
    }

    public void setTotalClinicalIncome(Double totalClinicalIncome) {
        this.totalClinicalIncome = totalClinicalIncome;
    }

    public Double getTotalSupplyExpenses() {
        return totalSupplyExpenses;
    }

    public void setTotalSupplyExpenses(Double totalSupplyExpenses) {
        this.totalSupplyExpenses = totalSupplyExpenses;
    }

    public Double getNetProfitOrLoss() {
        return netProfitOrLoss;
    }

    public void setNetProfitOrLoss(Double netProfitOrLoss) {
        this.netProfitOrLoss = netProfitOrLoss;
    }
}
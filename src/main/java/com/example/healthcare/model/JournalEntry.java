package com.example.healthcare.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "journal_entries")
public class JournalEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("accountType")
    @Column(name = "account_type")
    private String accountType; // "ASSET", "LIABILITY", "INCOME", "EXPENSE"

    private String description;

    private Double debit;

    private Double credit;

    @JsonProperty("entryDate")
    @Column(name = "entry_date")
    private String entryDate;

    public JournalEntry() {
    }

    public JournalEntry(String accountType, String description, Double debit, Double credit, String entryDate) {
        this.accountType = accountType;
        this.description = description;
        this.debit = debit;
        this.credit = credit;
        this.entryDate = entryDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getDebit() {
        return debit;
    }

    public void setDebit(Double debit) {
        this.debit = debit;
    }

    public Double getCredit() {
        return credit;
    }

    public void setCredit(Double credit) {
        this.credit = credit;
    }

    public String getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }
}
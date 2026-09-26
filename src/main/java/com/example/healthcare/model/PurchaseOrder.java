package com.example.healthcare.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "purchase_orders")
public class PurchaseOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("supplierId")
    @Column(name = "supplier_id")
    private Long supplierId;

    @JsonProperty("itemDescription")
    @Column(name = "item_description")
    private String itemDescription; // e.g., "Antibiotics Stock Batch A"

    private Double amount;

    private String status; // "ORDERED", "BILLED", "PAID"

    public PurchaseOrder() {
    }

    public PurchaseOrder(Long supplierId, String itemDescription, Double amount, String status) {
        this.supplierId = supplierId;
        this.itemDescription = itemDescription;
        this.amount = amount;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
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
package com.example.healthcare.controller;

import com.example.healthcare.Service.ProcurementService;
import com.example.healthcare.model.PurchaseOrder;
import com.example.healthcare.model.Supplier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/procurement")
public class ProcurementController {

    private final ProcurementService procurementService;

    public ProcurementController(ProcurementService procurementService) {
        this.procurementService = procurementService;
    }

    @PostMapping("/suppliers")
    public Supplier createSupplier(@RequestBody Supplier supplier) {
        return procurementService.createSupplier(supplier);
    }

    @GetMapping("/suppliers")
    public List<Supplier> getAllSuppliers() {
        return procurementService.getAllSuppliers();
    }

    @PostMapping("/purchase-orders")
    public PurchaseOrder createPurchaseOrder(@RequestBody PurchaseOrder po) {
        return procurementService.createPurchaseOrder(po);
    }

    @GetMapping("/purchase-orders")
    public List<PurchaseOrder> getAllPurchaseOrders() {
        return procurementService.getAllPurchaseOrders();
    }
}
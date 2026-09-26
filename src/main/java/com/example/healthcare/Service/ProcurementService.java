package com.example.healthcare.Service;

import com.example.healthcare.Repository.PurchaseOrderRepository;
import com.example.healthcare.Repository.SupplierRepository;
import com.example.healthcare.model.PurchaseOrder;
import com.example.healthcare.model.Supplier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcurementService {

    private final SupplierRepository supplierRepository;
    private final PurchaseOrderRepository purchaseOrderRepository;

    public ProcurementService(SupplierRepository supplierRepository, PurchaseOrderRepository purchaseOrderRepository) {
        this.supplierRepository = supplierRepository;
        this.purchaseOrderRepository = purchaseOrderRepository;
    }

    public Supplier createSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    public PurchaseOrder createPurchaseOrder(PurchaseOrder po) {
        if (po.getStatus() == null || po.getStatus().trim().isEmpty()) {
            po.setStatus("ORDERED");
        }
        return purchaseOrderRepository.save(po);
    }

    public List<PurchaseOrder> getAllPurchaseOrders() {
        return purchaseOrderRepository.findAll();
    }
}
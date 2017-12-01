package com.kodilla.good.patterns.food2door;

public class SupplierOrderProcessor {

    private Repository repository;
    private SupplierConnector supplierConnector;

    public SupplierOrderProcessor(final Repository repository, final SupplierConnector supplierConnector) {
        this.repository = repository;
        this.supplierConnector = supplierConnector;
    }

    public boolean process(SupplierOrder supplierOrder) {
        boolean isOrdered = supplierConnector.process(supplierOrder);
        if (isOrdered) {
            repository.createSupplierOrder(supplierOrder);
            boolean isOrderConfirmed = supplierConnector.receiveOrderConfirmation(supplierOrder.getId());
            repository.saveConfirmationStatus(supplierOrder.getId(), isOrderConfirmed);
            return isOrderConfirmed;
        }
        return false;
    }
}

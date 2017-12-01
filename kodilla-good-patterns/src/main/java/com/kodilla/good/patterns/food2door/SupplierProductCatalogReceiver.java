package com.kodilla.good.patterns.food2door;

import java.util.Map;

public class SupplierProductCatalogReceiver {

    private Repository repository;
    private SupplierConnector supplierConnector;

    public SupplierProductCatalogReceiver(final Repository repository, final SupplierConnector supplierConnector) {
        this.repository = repository;
        this.supplierConnector = supplierConnector;
    }

    public boolean receive() {
        Map<Integer, SupplierProduct> productCatalog = supplierConnector.importProductCatalog();
        if (!productCatalog.isEmpty()) {
            repository.importSupplierProducts(productCatalog);
            return true;
        }
        return false;
    }
}

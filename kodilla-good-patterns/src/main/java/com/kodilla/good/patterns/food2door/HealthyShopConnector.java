package com.kodilla.good.patterns.food2door;

import java.util.HashMap;
import java.util.Map;

public class HealthyShopConnector implements SupplierConnector {


    public boolean process(SupplierOrder order) {
        System.out.println("Order successfully sent to HealthyShop.");
        return true;
    }

    public boolean receiveOrderConfirmation(Long orderId) {
        System.out.println("HealthyShop confirmed order " + orderId + ".");
        return true;
    }

    public Map<Integer, SupplierProduct> importProductCatalog() {
        Map<Integer, SupplierProduct> productCatalog = new HashMap<>();
        System.out.println("Product catalog received from HealthyShop.");
        return productCatalog;
    }
}

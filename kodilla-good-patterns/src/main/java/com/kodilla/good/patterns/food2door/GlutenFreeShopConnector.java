package com.kodilla.good.patterns.food2door;

import java.util.HashMap;
import java.util.Map;

public class GlutenFreeShopConnector implements SupplierConnector {

    public boolean process(SupplierOrder order) {
        System.out.println("Order successfully sent to GlutenFreeShop.");
        return true;
    }

    public boolean receiveOrderConfirmation(Long orderId) {
        System.out.println("GlutenFreeShop confirmed order " + orderId + ".");
        return true;
    }

    public Map<Integer, SupplierProduct> importProductCatalog() {
        Map<Integer, SupplierProduct> productCatalog = new HashMap<>();
        System.out.println("Product catalog received from GlutenFreeShop.");
        return productCatalog;
    }
}

package com.kodilla.good.patterns.food2door;

import java.util.Map;
import java.util.stream.Collectors;

public class DbRepository implements Repository {

    public boolean importSupplierProducts(final Map<Integer, SupplierProduct> catalog) {
        System.out.println("Imported products to DB:");
        String importedProducts = catalog.entrySet().stream()
                .map(e -> e.getKey() + "\t" + e.getValue())
                .collect(Collectors.joining("\n"));
        System.out.println(importedProducts);

        return true;
    }

    public boolean createSupplierOrder(final SupplierOrder order) {
        System.out.println("Storing order " + order.getId() + " to the DB." );
        return true;
    }

    public boolean saveConfirmationStatus(Long orderId, boolean isConfirmed) {
        String status = isConfirmed ? "confirmed" : "rejected";
        System.out.println("Order " + orderId + " has been " + status + " by supplier.");
        return true;
    }

}

package com.kodilla.good.patterns.food2door;

import java.util.Map;

public interface SupplierConnector {

    boolean process(SupplierOrder order);

    boolean receiveOrderConfirmation(Long orderId);

    Map<Integer, SupplierProduct> importProductCatalog();

}

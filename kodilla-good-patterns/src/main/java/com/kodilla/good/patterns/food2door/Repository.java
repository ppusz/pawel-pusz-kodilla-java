package com.kodilla.good.patterns.food2door;

import java.util.Map;

public interface Repository {

    boolean importSupplierProducts(final Map<Integer, SupplierProduct> catalog);

    boolean createSupplierOrder(final SupplierOrder order);

    boolean saveConfirmationStatus(Long orderId, boolean isConfirmed);

}

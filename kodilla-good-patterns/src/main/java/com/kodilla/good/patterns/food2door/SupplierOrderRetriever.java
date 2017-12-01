package com.kodilla.good.patterns.food2door;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SupplierOrderRetriever {

    public SupplierOrder retrieve() {
        List<SupplierProduct> productsList = ProductsRetriever.retrieve();
        Map<SupplierProduct, Integer> orderProductMap = new HashMap();
        orderProductMap.put(productsList.get(0), 300);
        orderProductMap.put(productsList.get(1), 150);

        SupplierOrder.SupplierOrderBuilder orderBuilder = SupplierOrder.SupplierOrderBuilder.aSupplierOrder();
        orderBuilder.withId(4000012);
        orderBuilder.withDescription("Extra food needed ASAP!");
        orderBuilder.withOrderList(orderProductMap);

        return orderBuilder.build();
    }

}

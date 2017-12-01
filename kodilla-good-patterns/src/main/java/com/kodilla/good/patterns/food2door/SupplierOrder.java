package com.kodilla.good.patterns.food2door;

import java.util.Map;

public class SupplierOrder {

    private long id;
    private String description;
    Map<SupplierProduct, Integer> orderList;

    public SupplierOrder(final long id, final String description, final Map<SupplierProduct, Integer> orderList) {
        this.id = id;
        this.description = description;
        this.orderList = orderList;
    }

    public long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Map<SupplierProduct, Integer> getOrderList() {
        return orderList;
    }


    public static final class SupplierOrderBuilder {
        Map<SupplierProduct, Integer> orderList;
        private long id;
        private String description;

        private SupplierOrderBuilder() {
        }

        public static SupplierOrderBuilder aSupplierOrder() {
            return new SupplierOrderBuilder();
        }

        public SupplierOrderBuilder withId(long id) {
            this.id = id;
            return this;
        }

        public SupplierOrderBuilder withDescription(String description) {
            this.description = description;
            return this;
        }

        public SupplierOrderBuilder withOrderList(Map<SupplierProduct, Integer> orderList) {
            this.orderList = orderList;
            return this;
        }

        public SupplierOrder build() {
            return new SupplierOrder(id, description, orderList);
        }
    }
}

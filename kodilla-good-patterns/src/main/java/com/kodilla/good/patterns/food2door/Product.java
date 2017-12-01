package com.kodilla.good.patterns.food2door;

public abstract class Product {

    protected String productCode;
    protected String description;
    protected String unit;

    public Product(final String productCode, final String description, final String unit) {
        this.productCode = productCode;
        this.description = description;
        this.unit = unit;
    }

    public String getProductCode() {
        return productCode;
    }

    public String getDescription() {
        return description;
    }

    public String getUnit() {
        return unit;
    }
}

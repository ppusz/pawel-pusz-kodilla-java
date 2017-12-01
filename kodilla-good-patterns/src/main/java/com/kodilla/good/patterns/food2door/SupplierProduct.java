package com.kodilla.good.patterns.food2door;

import java.math.BigDecimal;

public class SupplierProduct extends Product {

    private String supplierCode;
    private double bundleSize;
    private BigDecimal price;
    private BigDecimal bundlePrice;
    private BigDecimal discount;

    public SupplierProduct(final String productCode, final String description, final String unit,
                           final String supplierCode, final double bundleSize, final BigDecimal price,
                           final BigDecimal bundlePrice, final BigDecimal discount) {
        super(productCode, description, unit);
        this.supplierCode = supplierCode;
        this.bundleSize = bundleSize;
        this.price = price;
        this.bundlePrice = bundlePrice;
        this.discount = discount;
    }

    public String getSupplierCode() {
        return supplierCode;
    }

    public double getBundleSize() {
        return bundleSize;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getBundlePrice() {
        return bundlePrice;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    @Override
    public String toString() {
        return "SupplierProduct{" +
                "supplierCode='" + supplierCode + '\'' +
                ", bundleSize=" + bundleSize +
                ", price=" + price +
                ", bundlePrice=" + bundlePrice +
                ", discount=" + discount +
                ", productCode='" + productCode + '\'' +
                ", description='" + description + '\'' +
                ", unit='" + unit + '\'' +
                '}';
    }
}

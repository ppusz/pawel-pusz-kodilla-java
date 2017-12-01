package com.kodilla.good.patterns.food2door;

import java.math.BigDecimal;

public final class SupplierProductBuilder {
    protected String productCode;
    protected String description;
    protected String unit;
    private String supplierCode;
    private double bundleSize;
    private BigDecimal price;
    private BigDecimal bundlePrice;
    private BigDecimal discount;

    private SupplierProductBuilder() {
    }

    public static SupplierProductBuilder aSupplierProduct() {
        return new SupplierProductBuilder();
    }

    public SupplierProductBuilder withProductCode(String productCode) {
        this.productCode = productCode;
        return this;
    }

    public SupplierProductBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public SupplierProductBuilder withSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
        return this;
    }

    public SupplierProductBuilder withUnit(String unit) {
        this.unit = unit;
        return this;
    }

    public SupplierProductBuilder withBundleSize(double bundleSize) {
        this.bundleSize = bundleSize;
        return this;
    }

    public SupplierProductBuilder withPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public SupplierProductBuilder withBundlePrice(BigDecimal bundlePrice) {
        this.bundlePrice = bundlePrice;
        return this;
    }

    public SupplierProductBuilder withDiscount(BigDecimal discount) {
        this.discount = discount;
        return this;
    }

    public SupplierProduct build() {
        return new SupplierProduct(productCode, description, unit, supplierCode, bundleSize, price, bundlePrice, discount);
    }
}

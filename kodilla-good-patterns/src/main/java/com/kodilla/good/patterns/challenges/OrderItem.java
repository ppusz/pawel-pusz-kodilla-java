package com.kodilla.good.patterns.challenges;

import java.math.BigDecimal;

public class OrderItem {

    private long product_id;
    private int quantity;
    private BigDecimal grossPrice;
    private BigDecimal grossValue;
    private BigDecimal unitDiscount;
    private BigDecimal discountValue;
    private BigDecimal nettoPrice;
    private BigDecimal nettoValue;

    public OrderItem(final long product_id, final int quantity, final BigDecimal grossPrice,
                     final BigDecimal grossValue, final BigDecimal unitDiscount, final BigDecimal discountValue,
                     final BigDecimal nettoPrice, final BigDecimal nettoValue) {
        this.product_id = product_id;
        this.quantity = quantity;
        this.grossPrice = grossPrice;
        this.grossValue = grossValue;
        this.unitDiscount = unitDiscount;
        this.discountValue = discountValue;
        this.nettoPrice = nettoPrice;
        this.nettoValue = nettoValue;
    }

    public long getProduct_id() {
        return product_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getGrossPrice() {
        return grossPrice;
    }

    public BigDecimal getGrossValue() {
        return grossValue;
    }

    public BigDecimal getUnitDiscount() {
        return unitDiscount;
    }

    public BigDecimal getDiscountValue() {
        return discountValue;
    }

    public BigDecimal getNettoPrice() {
        return nettoPrice;
    }

    public BigDecimal getNettoValue() {
        return nettoValue;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "product_id=" + product_id +
                ", quantity=" + quantity +
                ", grossPrice=" + grossPrice +
                ", grossValue=" + grossValue +
                ", unitDiscount=" + unitDiscount +
                ", discountValue=" + discountValue +
                ", nettoPrice=" + nettoPrice +
                ", nettoValue=" + nettoValue +
                '}';
    }
}

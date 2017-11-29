package com.kodilla.good.patterns.challenges;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Map;

public class OrderRequest {

    private User user;
    private Map<Integer, OrderItem> orderItems;
    private BigDecimal discount;
    private Currency currency;
    private Address deliveryAddress;
    private Address invoiceAddress;

    public OrderRequest(final User user, final Map<Integer, OrderItem> orderItems,
                        final BigDecimal discount, final Currency currency,
                        final Address deliveryAddress, final Address invoiceAddress) {
        this.user = user;
        this.orderItems = orderItems;
        this.discount = discount;
        this.currency = currency;
        this.deliveryAddress = deliveryAddress;
        this.invoiceAddress = invoiceAddress;
    }

    public User getUser() {
        return user;
    }

    public Map<Integer, OrderItem> getOrderItems() {
        return orderItems;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public Address getDeliveryAddress() {
        return deliveryAddress;
    }

    public Address getInvoiceAddress() {
        return invoiceAddress;
    }

    @Override
    public String toString() {
        return "OrderRequest{" +
                "\n\tuser=" + user +
                ", \n\torderItems=" + orderItems +
                ", \n\tdiscount=" + discount +
                ", \n\tcurrency=" + currency +
                ", \n\tdeliveryAddress=" + deliveryAddress +
                ", \n\tinvoiceAddress=" + invoiceAddress +
                "\n}";
    }
}

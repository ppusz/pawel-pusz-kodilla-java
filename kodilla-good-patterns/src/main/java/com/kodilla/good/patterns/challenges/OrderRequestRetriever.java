package com.kodilla.good.patterns.challenges;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.HashMap;
import java.util.Map;

public class OrderRequestRetriever {

    public OrderRequest retrieve() {

        Address address = new Address(
                "John Smith",
                "aleja Łukasza Cieplińskiego 3",
                "",
                "Rzeszów",
                "35-001",
                "Podkarpackie",
                "Polska",
                "123456798");

        User user = new User(
                "johnsmith",
                "John",
                "Smith",
                "john.smith@example.com",
                address);

        Map<Integer, OrderItem> orderItems = new HashMap<>();
        orderItems.put(1, new OrderItem(1001, 1, new BigDecimal(100), new BigDecimal(100),
                BigDecimal.ZERO, BigDecimal.ZERO, new BigDecimal(100), new BigDecimal(100)));
        orderItems.put(2, new OrderItem(2001, 10, new BigDecimal(1.2), new BigDecimal(12),
                new BigDecimal("0.2"), new BigDecimal("2"), new BigDecimal(1), new BigDecimal(10)));

        BigDecimal discount = BigDecimal.ZERO;
        Currency currency = Currency.getInstance("PLN");

        return new OrderRequest(user, orderItems, discount, currency, user.getAddress(), user.getAddress());
    }
}

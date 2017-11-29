package com.kodilla.good.patterns.challenges;

public class DbRepository implements OrderRepository {

    public boolean createOrder(OrderRequest orderRequest) {
        System.out.println("Saving order in database.");
        return true;
    }
}

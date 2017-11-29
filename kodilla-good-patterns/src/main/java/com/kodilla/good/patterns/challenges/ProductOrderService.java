package com.kodilla.good.patterns.challenges;

public class ProductOrderService implements OrderService {

    public boolean order(OrderRequest orderRequest) {
        System.out.println("Executing product order for following data:");
        System.out.println(orderRequest);
        return true;
    }

}

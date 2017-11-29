package com.kodilla.good.patterns.challenges;

public class OrderRunner {

    public static void main(String[] args) {
        OrderRequestRetriever orderRequestRetriever = new OrderRequestRetriever();
        OrderRequest orderRequest = orderRequestRetriever.retrieve();

        OrderProcessor orderProcessor = new OrderProcessor(
                new ProductOrderService(), new DbRepository(), new MailService());
        orderProcessor.process(orderRequest);
    }
}

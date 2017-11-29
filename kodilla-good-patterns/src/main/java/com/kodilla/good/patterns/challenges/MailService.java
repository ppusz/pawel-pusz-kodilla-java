package com.kodilla.good.patterns.challenges;

public class MailService implements InformationService {

    public void inform(OrderRequest orderRequest) {
        System.out.println("Sending an email to user with order confirmation.");
    }
}

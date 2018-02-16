package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class HamPizzaDecorator extends AbstractPizzaDecorator {

    public HamPizzaDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + ham";
    }

    @Override
    public BigDecimal getPrice() {
        return super.getPrice().add(new BigDecimal(4));
    }
}

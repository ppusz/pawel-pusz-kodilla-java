package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class GarlicPizzaDecorator extends AbstractPizzaDecorator {

    public GarlicPizzaDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " and a lot of garlic";
    }

    @Override
    public BigDecimal getPrice() {
        return super.getPrice().add(new BigDecimal(3));
    }
}

package com.kodilla.spring.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public final class Calculator {

    @Autowired
    private Display display;

    public double add(final double a, final double b) {
        final double result = a + b;
        display.displayValue(result);
        return result;
    }

    public double sub(final double a, final double b) {
        final double result = a - b;
        display.displayValue(result);
        return result;
    }

    public double mul(final double a, final double b) {
        final double result = a * b;
        display.displayValue(result);
        return result;
    }

    public double div(final double a, final double b) {
        final double result = a / b;
        display.displayValue(result);
        return result;
    }
}

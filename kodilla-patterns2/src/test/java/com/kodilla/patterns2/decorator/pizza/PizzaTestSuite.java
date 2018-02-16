package com.kodilla.patterns2.decorator.pizza;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class PizzaTestSuite {

    @Test
    public void testBasicPizzaGetPrice() {
        // Given
        Pizza pizza = new BasicPizza();
        // When
        BigDecimal calculatedPrice = pizza.getPrice();
        // Then
        assertEquals(new BigDecimal(10), calculatedPrice);
    }

    @Test
    public void testBasicPizzaGetDescription() {
        // Given
        Pizza pizza = new BasicPizza();
        // When
        String description = pizza.getDescription();
        // Then
        assertEquals("Dough with tomato sauce and cheese", description);
    }

    @Test
    public void testPizzaWithHamGetPrice() {
        // Given
        Pizza pizza = new BasicPizza();
        pizza = new HamPizzaDecorator(pizza);
        // When
        BigDecimal calculatedPrice = pizza.getPrice();
        // Then
        assertEquals(new BigDecimal(14), calculatedPrice);
    }

    @Test
    public void testPizzaWithHamGetDescription() {
        // Given
        Pizza pizza = new BasicPizza();
        pizza = new HamPizzaDecorator(pizza);
        // When
        String description = pizza.getDescription();
        // Then
        assertEquals("Dough with tomato sauce and cheese + ham", description);
    }

    @Test
    public void testPizzaWithHamAndSalamiGetPrice() {
        // Given
        Pizza pizza = new BasicPizza();
        pizza = new HamPizzaDecorator(pizza);
        pizza = new SalamiPizzaDecorator(pizza);
        // When
        BigDecimal calculatedPrice = pizza.getPrice();
        // Then
        assertEquals(new BigDecimal(18), calculatedPrice);
    }

    @Test
    public void testPizzaWithHamAndSalamiGetDescription() {
        // Given
        Pizza pizza = new BasicPizza();
        pizza = new HamPizzaDecorator(pizza);
        pizza = new SalamiPizzaDecorator(pizza);
        // When
        String description = pizza.getDescription();
        // Then
        assertEquals("Dough with tomato sauce and cheese + ham + salami", description);
    }

    @Test
    public void testPizzaWithHamAndSalamiAndGarlicGetPrice() {
        // Given
        Pizza pizza = new BasicPizza();
        pizza = new HamPizzaDecorator(pizza);
        pizza = new SalamiPizzaDecorator(pizza);
        pizza = new GarlicPizzaDecorator(pizza);
        // When
        BigDecimal calculatedPrice = pizza.getPrice();
        // Then
        assertEquals(new BigDecimal(21), calculatedPrice);
    }

    @Test
    public void testPizzaWithHamAndSalamiAndGarlicGetDescription() {
        // Given
        Pizza pizza = new BasicPizza();
        pizza = new HamPizzaDecorator(pizza);
        pizza = new SalamiPizzaDecorator(pizza);
        pizza = new GarlicPizzaDecorator(pizza);
        // When
        String description = pizza.getDescription();
        // Then
        assertEquals("Dough with tomato sauce and cheese + ham + salami and a lot of garlic", description);
    }
}

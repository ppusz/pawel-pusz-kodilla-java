package com.kodilla.spring.calculator;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatorTestSuite {

    @Test
    public void testCalculations() {
        //Given
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.kodilla.spring.calculator");
        Calculator calculator = context.getBean(Calculator.class);

        //When
        double sum = calculator.add(4, 2);
        double diff = calculator.sub(4, 2);
        double product = calculator.mul(4, 2);
        double quotient = calculator.div(4, 2);

        //Then
        Assert.assertEquals(6, sum, 0);
        Assert.assertEquals(2, diff, 0);
        Assert.assertEquals(8, product, 0);
        Assert.assertEquals(2, quotient, 0);
    }
}

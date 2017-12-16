package com.kodilla.patterns.builder.bigmac;

import org.junit.Assert;
import org.junit.Test;

public class BigmacTestSuite {

    @Test
    public void testBigmacNew() {
        //Given
        Bigmac.BigmacBuilder bigmacBuilder = new Bigmac.BigmacBuilder()
                .ingredient(Ingredient.BACON)
                .bun(true)
                .burgers(2)
                .sauce(Sauce.BBQ)
                .ingredient(Ingredient.LETTUCE)
                .ingredient(Ingredient.CUCUMBER)
                .ingredient(Ingredient.CHEESE);

        //When
        Bigmac bigmac = bigmacBuilder.build();

        //Then
        System.out.println(bigmac);
        boolean bunWithSesameSeeds = bigmac.getBun().withSesame();
        String sauce = "";
        if (bigmac.getSauce() != null) {
            sauce = bigmac.getSauce().getName();
        }
        int burgersCount = bigmac.getBurgers();
        int ingredientsCount = bigmac.getIngredients().size();

        Assert.assertTrue(bunWithSesameSeeds);
        Assert.assertEquals(Sauce.BBQ, sauce);
        Assert.assertEquals(2, burgersCount);
        Assert.assertEquals(4, ingredientsCount);
    }
}

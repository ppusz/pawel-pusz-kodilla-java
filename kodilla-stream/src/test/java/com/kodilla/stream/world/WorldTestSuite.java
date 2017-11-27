package com.kodilla.stream.world;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class WorldTestSuite {

    @Test
    public void testGetPeopleQuantity() {
        //Given
        Continent asia = new Continent();
        Continent africa = new Continent();
        Continent europe = new Continent();
        Continent northAmerica = new Continent();
        Continent southAmerica = new Continent();
        Continent australia = new Continent();
        Continent antarctica = new Continent();

        Country china = new Country(new BigDecimal("1409517397"));
        asia.addCountry(china);
        Country india = new Country(new BigDecimal("1339180127"));
        asia.addCountry(india);
        Country indonesia = new Country(new BigDecimal("263991379"));
        asia.addCountry(indonesia);
        Country pakistan = new Country(new BigDecimal("197015955"));
        asia.addCountry(pakistan);
        Country bangladesh = new Country(new BigDecimal("164669751"));
        asia.addCountry(bangladesh);

        Country nigeria = new Country(new BigDecimal("190886311"));
        africa.addCountry(nigeria);
        Country ethiopia = new Country(new BigDecimal("104957438"));
        africa.addCountry(ethiopia);
        Country egypt = new Country(new BigDecimal("97553151"));
        africa.addCountry(egypt);
        Country congo = new Country(new BigDecimal("81339988"));
        africa.addCountry(congo);
        Country tanzania = new Country(new BigDecimal("57310019"));
        africa.addCountry(tanzania);

        Country germany = new Country(new BigDecimal("82114224"));
        europe.addCountry(germany);
        Country uk = new Country(new BigDecimal("66181585"));
        europe.addCountry(uk);
        Country france = new Country(new BigDecimal("64979548"));
        europe.addCountry(france);
        Country italy = new Country(new BigDecimal("59359900"));
        europe.addCountry(italy);
        Country spain = new Country(new BigDecimal("46354321"));
        europe.addCountry(spain);

        Country brazil = new Country(new BigDecimal("209288278"));
        southAmerica.addCountry(brazil);
        Country mexico = new Country(new BigDecimal("129163276"));
        southAmerica.addCountry(mexico);
        Country colombia = new Country(new BigDecimal("49065615"));
        southAmerica.addCountry(colombia);
        Country argentina = new Country(new BigDecimal("44271041"));
        southAmerica.addCountry(argentina);
        Country peru = new Country(new BigDecimal("32165485"));
        southAmerica.addCountry(peru);

        Country us = new Country(new BigDecimal("324459463"));
        northAmerica.addCountry(us);
        Country canada = new Country(new BigDecimal("36624199"));
        northAmerica.addCountry(canada);

        Country australiaCountry = new Country(new BigDecimal("24450561"));
        australia.addCountry(australiaCountry);
        Country papuaNewGuinea = new Country(new BigDecimal("8251162"));
        australia.addCountry(papuaNewGuinea);

        //When
        World world = new World();
        world.addContinent(europe);
        world.addContinent(asia);
        world.addContinent(africa);
        world.addContinent(australia);
        world.addContinent(northAmerica);
        world.addContinent(southAmerica);
        world.addContinent(antarctica);

        //Then
        BigDecimal expectedPeopleQuantity = new BigDecimal("5083150174");
        Assert.assertEquals(expectedPeopleQuantity, world.getPeopleQuantity());
    }

}

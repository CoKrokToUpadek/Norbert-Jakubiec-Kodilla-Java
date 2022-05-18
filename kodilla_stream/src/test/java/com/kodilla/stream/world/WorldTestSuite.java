package com.kodilla.stream.world;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class WorldTestSuite {

    @Test
   public void testGetPeopleQuantity(){

        //Given
        World world=new World();

        Continent africa=new Continent("Africa");
        Continent europe=new Continent("Europe");
        Continent northAmerica=new Continent("North America");

        Country africa1=new Country("Nigeria",new BigDecimal("112330"));
        Country africa2=new Country("Egypt",new BigDecimal("12311"));
        Country africa3=new Country("Chad",new BigDecimal("144122"));

        africa.addCountry(africa1);
        africa.addCountry(africa2);
        africa.addCountry(africa3);

        Country europe1=new Country("Poland",new BigDecimal("324141"));
        Country europe2=new Country("Germany",new BigDecimal("44214124125"));
        Country europe3=new Country("France",new BigDecimal("52151"));

        europe.addCountry(europe1);
        europe.addCountry(europe2);
        europe.addCountry(europe3);

        Country nAmerica1=new Country("Canada",new BigDecimal("45125"));
        Country nAmerica2=new Country("United States",new BigDecimal("65152"));
        northAmerica.addCountry(nAmerica1);
        northAmerica.addCountry(nAmerica2);

         world.addContinent(europe);
         world.addContinent(northAmerica);
         world.addContinent(africa);

        //When
        BigDecimal expectedSum=new BigDecimal("44214879457");
        BigDecimal functionSum=world.getPeopleQuantity();

        //Then
        Assertions.assertEquals(expectedSum,functionSum);

    }
}

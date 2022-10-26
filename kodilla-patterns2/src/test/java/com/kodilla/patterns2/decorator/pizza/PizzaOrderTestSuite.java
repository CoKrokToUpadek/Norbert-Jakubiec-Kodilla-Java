package com.kodilla.patterns2.decorator.pizza;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PizzaOrderTestSuite {

    @Test
    void BasicPizzaPriceTest(){
        // Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        // When
        BigDecimal calculatedCost = theOrder.getPrice();
        // Then
        assertEquals(new BigDecimal(15), calculatedCost);
    }

    @Test
    void BasicPizzaIngredientsTest(){
        // Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        // When
        String ingredients = theOrder.getIngredients();
        // Then
        assertEquals("Pizza with basic ingredients: dough, tomato sauce, cheese", ingredients);
    }

    @Test
    void PizzaWithSomeStuffOnItPriceTest(){
        // Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder=new HamAdditionDecorator(theOrder);
        theOrder=new SalamiAdditionDecorator(theOrder);
        theOrder=new MushroomsAdditionDecorator(theOrder);
        // When
        BigDecimal calculatedCost = theOrder.getPrice();
        // Then
        assertEquals(new BigDecimal(30), calculatedCost);
    }

    @Test
    void PizzaWithSomeStuffOnItIngredientsTest(){
        // Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder=new HamAdditionDecorator(theOrder);
        theOrder=new SalamiAdditionDecorator(theOrder);
        theOrder=new MushroomsAdditionDecorator(theOrder);
        // When
        String ingredients = theOrder.getIngredients();
        // Then
        assertEquals("Pizza with basic ingredients: dough, tomato sauce, cheese/d Additional Ham/d Additional Salami/d Additional Mushrooms", ingredients);
    }

    @Test
    void SpawnOfSatanFlavorPizzaPriceTest(){
        // Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder=new PineappleAdditionDecorator(theOrder);
        theOrder=new PineappleAdditionDecorator(theOrder);
        theOrder=new PineappleAdditionDecorator(theOrder);
        theOrder=new PineappleAdditionDecorator(theOrder);

        // When
        BigDecimal calculatedCost = theOrder.getPrice();
        // Then
        assertEquals(new BigDecimal(55), calculatedCost);
    }

    @Test
    void SpawnOfSatanFlavorPizzaIngredientsTest(){
        // Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder=new PineappleAdditionDecorator(theOrder);
        theOrder=new PineappleAdditionDecorator(theOrder);
        theOrder=new PineappleAdditionDecorator(theOrder);
        theOrder=new PineappleAdditionDecorator(theOrder);

        // When
        String ingredients = theOrder.getIngredients();
        // Then
        assertEquals("Pizza with basic ingredients: dough, tomato sauce, cheese" +
                "/d Additional Pineapple (God have mercy)" +
                "/d Additional Pineapple (God have mercy)" +
                "/d Additional Pineapple (God have mercy)" +
                "/d Additional Pineapple (God have mercy)", ingredients);
    }

}

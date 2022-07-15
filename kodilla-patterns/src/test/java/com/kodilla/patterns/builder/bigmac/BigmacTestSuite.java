package com.kodilla.patterns.builder.bigmac;

import com.kodilla.patterns.builder.pizza.Pizza;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BigmacTestSuite {
    @Test
    void testNewBigmac() {
        //Given
        Bigmac bigmac=new Bigmac.BigmacBuilder()
                .bun("with sesame")
                .sauce("german")
                .burgers(2)
                .ingredient("Mushrooms")
                .ingredient("cheese")
                .build();

        System.out.println(bigmac);
        //When
        int howManyIngredients = bigmac.getIngredients().size();
        //Then
        assertEquals(2, howManyIngredients);
    }
}

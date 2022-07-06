package com.kodilla.spring.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CalculatorTestSuite {
    @Autowired
    private Calculator calculator;

    @Test
    public void testCalculations(){
        Assertions.assertEquals(calculator.add(2,1),3,0.00001);
        Assertions.assertEquals(calculator.sub(2,1),1,0.00001);
        Assertions.assertEquals(calculator.mul(2,2),4,0.00001);
        Assertions.assertEquals(calculator.div(6,3),2,0.00001);
    }

}

package com.kodilla.stream.array;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.OptionalDouble;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class ArrayOperationsTestSuite {

    @Test
    public void testGetAverage(){

        //Given
        int [] testArray=new int[20];
        for (int i=0;i<20;i++){
            testArray[i]=i*2;
        }

        //When
        double functionCalc=ArrayOperations.getAverage(testArray);

        //Then
        Assertions.assertEquals(19,functionCalc);
    }
}

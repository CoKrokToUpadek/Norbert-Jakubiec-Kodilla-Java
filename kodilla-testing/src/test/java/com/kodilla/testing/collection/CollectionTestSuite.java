package com.kodilla.testing.collection;
import org.junit.jupiter.api.*;


import java.util.ArrayList;
import java.util.List;

public class CollectionTestSuite {
    //ps. chciałem zrobic zadanie dodatkowe ale nie wiem co poeta ma w nim na mysli

    @BeforeAll
   static public void beforeAll(){
        System.out.println("testing begins");
    }

    @AfterAll
   static   public void afterAll(){
        System.out.println("testing ends");
    }

    @BeforeEach
    public void beforeEach(){
        System.out.println("test case: begin");
    }

    @AfterEach
    public void afterEach(){
        System.out.println("test case: end");
    }


    @DisplayName("test behavior if list is empty")
    @Test
    public void testOddNumbersExterminatorEmptyList(){
        //Given
        List<Integer> inputValues=new ArrayList<>();

        //When
        List<Integer> outputValues=OddNumbersExterminator.exterminate(inputValues);

        //Then
        Assertions.assertEquals(inputValues,outputValues);
    }
    @DisplayName("test behavior if list have valid data")
    @Test
    public void testOddNumbersExterminatorNormalList(){

        //Given
        List<Integer> inputValues=new ArrayList<>();
        for (int i=0;i<90;i++){
            inputValues.add(i);
        }

        //When
        List<Integer> outputValues=OddNumbersExterminator.exterminate(inputValues);

        //Then
        for (Integer num : outputValues){
            Assertions.assertTrue(num%2==0);
        }
    }
}

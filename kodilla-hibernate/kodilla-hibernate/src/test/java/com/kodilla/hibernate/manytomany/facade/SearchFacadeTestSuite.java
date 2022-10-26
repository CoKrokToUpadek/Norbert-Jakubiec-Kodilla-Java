package com.kodilla.hibernate.manytomany.facade;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SearchFacadeTestSuite {

    @Autowired
    private SearchFacade searchFacade;

    @Test
    void searchFacadeTest()  {
         Assertions.assertTrue(searchFacade.findCompanyByNameFragment("Grey"));
         Assertions.assertTrue(searchFacade.findEmployeeByNameFragment("John"));
         Assertions.assertFalse(searchFacade.findEmployeeByNameFragment("Wrong stuff"));
    }


}

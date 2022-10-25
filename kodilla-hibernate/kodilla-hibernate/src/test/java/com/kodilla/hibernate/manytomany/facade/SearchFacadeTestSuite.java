package com.kodilla.hibernate.manytomany.facade;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SearchFacadeTestSuite {

    @Autowired
    private SearchFacade searchFacade;

    @Test
    void searchFacadeTest()  {
           searchFacade.findCompanyByNameFragment("Grey");
           searchFacade.findEmployeeByNameFragment("John");
           searchFacade.findEmployeeByNameFragment("Wrong stuff");
    }


}

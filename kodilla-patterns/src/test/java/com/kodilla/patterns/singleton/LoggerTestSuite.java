package com.kodilla.patterns.singleton;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class LoggerTestSuite {

    private static Logger logger;

    @BeforeAll
    public static void openSettingsFile() {

       logger=Logger.INSTANCE;
       logger.log("potato");

    }


    @Test
    void testGetFileName() {
        //Given
        //When
        String log = logger.getLastLog();
        //Then
        assertEquals("potato", log);
    }

}

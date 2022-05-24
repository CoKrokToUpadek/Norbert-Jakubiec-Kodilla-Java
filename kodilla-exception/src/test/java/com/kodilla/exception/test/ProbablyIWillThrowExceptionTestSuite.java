package com.kodilla.exception.test;

import com.kodilla.exception.io.FileReaderException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProbablyIWillThrowExceptionTestSuite {

    @Test
    void ProbablyIWillThrowExceptionTest(){
        //given
        SecondChallenge secondChallenge=new SecondChallenge();

                                    /*(x >= 2 || x < 1 || y == 1.5)*/
        //when-then
        Assertions.assertAll(
                () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(2,1.5)),
                () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(2,1)),
                () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(1.5,1.5)),
                () -> assertDoesNotThrow(() -> secondChallenge.probablyIWillThrowException(1.5,2))
        );

    }
}

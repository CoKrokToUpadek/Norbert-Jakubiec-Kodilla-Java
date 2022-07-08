package com.kodilla.spring.board;

import com.kodilla.spring.portfolio.Board;
import com.kodilla.spring.portfolio.BoardConfig;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


@SpringBootTest
public class BoardTestSuite {

        @Test
        void testTaskAdd() {
            //Given
            ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
            Board board = context.getBean(Board.class);

            //When & Then
            System.out.println("------lists with default values------");
            board.getDoneList().printTask();
            board.getInProgressList().printTask();
            board.getToDoList().printTask();

            System.out.println("------lists with added values------");
            board.getDoneList().addTask("added done task");
            board.getDoneList().printTask();

            board.getInProgressList().addTask("added in progress task");
            board.getInProgressList().printTask();

            board.getToDoList().addTask("added todo task");
            board.getToDoList().printTask();

        }

}

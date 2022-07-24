package com.kodilla.sudoku;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

public class SudokuTestingSuite {
    @Test
    public void testPrinting() {   //given
        SudokuBoard board = new SudokuBoard(9);
        board.generateEmptyBoard();
        //when
        //then
        System.out.println(board);
    }

    @Test
    public void testSettingSingleElement() {
        //given
        SudokuBoard board = new SudokuBoard(9);
        board.generateEmptyBoard();
        //when
        board.setElement(3, 1, 7);
        SudokuElement tempElement = board.getElement(1, 3);
        //then
        Assertions.assertEquals(tempElement.getCurrentFieldValue(), 7);
        System.out.println(board);
    }


    @Test
    public void testRemoveElementFromPossibleValuesRow() {
        //given
        SudokuGame game = new SudokuGame(9);
        //when
        game.getGameBoard().setElement(0, 0, 6);
        game.getGameBoard().setElement(1, 0, 7);
        game.sudokuSolver();
        SudokuElement tempElement = game.getGameBoard().getElement(2, 0);
        //then
        Assertions.assertFalse(tempElement.possibleValues.getPossibleValues().contains(6));
        tempElement.possibleValues.printPossibleValues();
    }

    @Test
    public void testRemoveElementFromPossibleValuesRowAndColumn() {
        //given
        SudokuGame game = new SudokuGame(9);
        //when
        for (int i = 0; i < 9; i++) {
            game.getGameBoard().setElement(i, 0, i + 1);
        }
        game.getGameBoard().setElement(1, 1, 4);
        game.sudokuSolver();
        SudokuElement tempElement = game.getGameBoard().getElement(1, 0);
        SudokuElement tempElement2 = game.getGameBoard().getElement(1, 6);
        //then
        game.PrintGameState();
        Assertions.assertFalse(tempElement.possibleValues.getPossibleValues().contains(3));
        Assertions.assertFalse(tempElement2.possibleValues.getPossibleValues().contains(7));
        Assertions.assertTrue(tempElement.possibleValues.getPossibleValues().contains(8));
        tempElement.possibleValues.printPossibleValues();
    }

    @Test
    public void testWritingLastMissingElementToTheRow() {
        //given
        SudokuGame game = new SudokuGame(9);

        //when
        for (int i = 2; i < 9; i++) {
            game.getGameBoard().setElement(i, 0, i + 1);
        }
        game.getGameBoard().setElement(0, 0, 2);
        game.sudokuSolver();
        SudokuElement tempElement = game.getGameBoard().getElement(0, 1);

        //then
        tempElement.possibleValues.printPossibleValues();
        Assertions.assertEquals(0, tempElement.possibleValues.getPossibleValues().size());
        game.PrintGameState();
    }


    @Test
    public void testWritingMultipleElementsToGameBoard() {
        //given
        SudokuGame game = new SudokuGame(9);
        //when
        for (int i = 2; i < 9; i++) {
            game.getGameBoard().setElement(i, 0, i + 1);
        }
        game.getGameBoard().setElement(0, 2, 4);
        game.getGameBoard().setElement(1, 1, 5);
        game.getGameBoard().setElement(1, 2, 6);
        game.getGameBoard().setElement(2, 1, 7);
        game.getGameBoard().setElement(1, 3, 1);
        game.getGameBoard().setElement(0, 3, 8);
        game.sudokuSolver();
        SudokuElement tempElement = game.getGameBoard().getElement(2, 2);
        //then
        Assertions.assertEquals(2, tempElement.possibleValues.getPossibleValues().size());
        game.PrintGameState();
        tempElement.possibleValues.printPossibleValues();
    }

    @Test
    public void testForSolvingSudoku() {
        //given
        SudokuGame game = new SudokuGame(9);

        game.getGameBoard().setElement(1, 0, 2);
        game.getGameBoard().setElement(3, 0, 5);
        game.getGameBoard().setElement(5, 0, 1);
        game.getGameBoard().setElement(7, 0, 9);
        game.getGameBoard().setElement(0, 1, 8);
        game.getGameBoard().setElement(3, 1, 2);
        game.getGameBoard().setElement(5, 1, 3);
        game.getGameBoard().setElement(8, 1, 6);
        game.getGameBoard().setElement(1, 2, 3);
        game.getGameBoard().setElement(4, 2, 6);
        game.getGameBoard().setElement(7, 2, 7);
        game.getGameBoard().setElement(2, 3, 1);
        game.getGameBoard().setElement(6, 3, 6);
        game.getGameBoard().setElement(0, 4, 5);
        game.getGameBoard().setElement(1, 4, 4);
        game.getGameBoard().setElement(7, 4, 1);
        game.getGameBoard().setElement(8, 4, 9);
        game.getGameBoard().setElement(2, 5, 2);
        game.getGameBoard().setElement(6, 5, 7);
        game.getGameBoard().setElement(1, 6, 9);
        game.getGameBoard().setElement(4, 6, 3);
        game.getGameBoard().setElement(7, 6, 8);
        game.getGameBoard().setElement(0, 7, 2);
        game.getGameBoard().setElement(3, 7, 8);
        game.getGameBoard().setElement(8, 7, 7);
        game.getGameBoard().setElement(5, 7, 4);
        game.getGameBoard().setElement(1, 8, 1);
        game.getGameBoard().setElement(3, 8, 9);
        game.getGameBoard().setElement(5, 8, 7);
        game.getGameBoard().setElement(7, 8, 6);

        game.getGameBoard().setElement(0, 0, 4);

        //when
        game.sudokuSolver();
        boolean testForEmptyCells = game.getGameBoard().getSudokuBoard().stream().flatMap(s -> s.getSudokuRow().
                stream()).collect(Collectors.toList()).stream().anyMatch(s -> s.getCurrentFieldValue() == -1);
        SudokuElement tempElement = game.getGameBoard().getElement(1, 7);
        //then
        Assertions.assertFalse(testForEmptyCells);
        game.PrintGameState();
        tempElement.possibleValues.printPossibleValues();
    }


    @Test
    public void testForInvalidSudoku() {
        //given
        SudokuGame game = new SudokuGame(9);

        game.getGameBoard().setElement(1, 0, 2);
        game.getGameBoard().setElement(3, 0, 5);
        game.getGameBoard().setElement(5, 0, 1);
        game.getGameBoard().setElement(7, 0, 9);
        game.getGameBoard().setElement(0, 1, 8);
        game.getGameBoard().setElement(3, 1, 2);
        game.getGameBoard().setElement(5, 1, 3);
        game.getGameBoard().setElement(8, 1, 6);
        game.getGameBoard().setElement(1, 2, 3);
        game.getGameBoard().setElement(4, 2, 6);
        game.getGameBoard().setElement(7, 2, 7);
        game.getGameBoard().setElement(2, 3, 1);
        game.getGameBoard().setElement(6, 3, 6);
        game.getGameBoard().setElement(0, 4, 5);
        game.getGameBoard().setElement(1, 4, 4);
        game.getGameBoard().setElement(7, 4, 1);
        game.getGameBoard().setElement(8, 4, 9);
        game.getGameBoard().setElement(2, 5, 2);
        game.getGameBoard().setElement(6, 5, 7);
        game.getGameBoard().setElement(1, 6, 9);
        game.getGameBoard().setElement(4, 6, 3);
        game.getGameBoard().setElement(7, 6, 8);
        game.getGameBoard().setElement(0, 7, 2);
        game.getGameBoard().setElement(3, 7, 8);
        game.getGameBoard().setElement(8, 7, 7);
        game.getGameBoard().setElement(5, 7, 4);
        game.getGameBoard().setElement(1, 8, 1);
        game.getGameBoard().setElement(3, 8, 9);
        game.getGameBoard().setElement(5, 8, 7);
        game.getGameBoard().setElement(7, 8, 6);

        game.getGameBoard().setElement(0, 0, 4);
        game.getGameBoard().setElement(4, 0, 6);
        game.getGameBoard().setElement(8, 0, 7);
        //when
        game.sudokuSolver();
        SudokuElement tempElement = game.getGameBoard().getElement(0, 0);
        //then
        game.PrintGameState();
        tempElement.possibleValues.printPossibleValues();

    }

    @Test
    public void test1ElementInSudoku() {
        //given
        SudokuGame game = new SudokuGame(9);

        //game.getGameBoard().setElement(0, 0, 0);


        //when
        game.sudokuSolver();
        SudokuElement tempElement = game.getGameBoard().getElement(0, 0);
        //then
        game.PrintGameState();
        tempElement.possibleValues.printPossibleValues();

    }

}

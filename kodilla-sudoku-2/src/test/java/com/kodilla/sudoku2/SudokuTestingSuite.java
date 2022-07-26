package com.kodilla.sudoku2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class SudokuTestingSuite {
    @Test
    void testCreateEmptySudokuElement() {
        //given
        SudokuElement element = new SudokuElement();
        List<Integer> testValuesList = new ArrayList<>(SudokuPossibleValuesReference.VALUESREFTABLE);

        //when
        int testedElement = element.getCurrentSudokuElementValue();
        //then
        Assertions.assertEquals(-1, testedElement);
        Assertions.assertTrue(element.getPossibleSudokuElementValues().containsAll(testValuesList));
    }

    @Test
    void testCopySudokuElement() {
        //given
        SudokuElement element = new SudokuElement();
        SudokuElement element1 = new SudokuElement(element);
        //when
        element.setCurrentSudokuElementValue(1);


            element.removeElementFromPossibleValuesByValue(2);

        //then
        Assertions.assertEquals(-1, element1.getCurrentSudokuElementValue());
        Assertions.assertTrue(element1.getPossibleSudokuElementValues().contains(2));
    }


    @Test
    void testGenerateEmptySudokuBoard(){
        //given
        SudokuBoard board=new SudokuBoard();
        board.generateEmptyBoard();
        //when
        SudokuElement element=board.getElement(1,1);
        //then
        Assertions.assertEquals(-1,element.getCurrentSudokuElementValue());
        System.out.println(board);
    }

    @Test
    void testForSettingElement(){
        //given
        SudokuBoard board=new SudokuBoard();
        SudokuElement element;
        board.generateEmptyBoard();
        //when
            board.setElement(0,0,7);
            element=board.getElement(0,0);


        Assertions.assertEquals(7,element.getCurrentSudokuElementValue());
        System.out.println(board);
    }

    @Test
    void testUpdatingPossibleValuesList(){
        //given
        SudokuBoard board=new SudokuBoard();
        SudokuElement element;
        board.generateEmptyBoard();
        SudokuSolver solver=new SudokuSolver(board);
        //when
        try {
            board.setElement(0,0,1);
            board.setElement(1,0,2);
            solver.validateElementsAndCheckForException();
        } catch (BacktrackSudokuException e) {
            System.out.println(e.getMessage());
        } catch (InvalidSudokuException e) {
            throw new RuntimeException(e);
        }
        element=board.getElement(0,0);
        //then
        Assertions.assertFalse(element.getPossibleSudokuElementValues().contains(1));
        element.printPossibleSudokuValues();
    }

    @Test
    void testGuessingMechanism(){
        SudokuBoard board=new SudokuBoard();
        SudokuElement element;
        board.generateEmptyBoard();
        SudokuSolver solver=new SudokuSolver(board);
        //when
        try {
            board.setElement(0,0,1);
            board.setElement(1,0,2);
            solver.validateElementsAndCheckForException();
            solver.guessSudokuElementValue();
        } catch (BacktrackSudokuException | InvalidSudokuException e) {
            System.out.println(e.getMessage());
        }
        element=board.getElement(0,2);
        //then
        Assertions.assertEquals(3,element.getCurrentSudokuElementValue());
        System.out.println(board);

    }

   @Test
    public void testForSolvingSudoku() {
        //given
        SudokuBoard board = new SudokuBoard();
        board.generateEmptyBoard();
        SudokuSolver solver=new SudokuSolver(board);
        board.setElement(1, 0, 2);
        board.setElement(3, 0, 5);
        board.setElement(5, 0, 1);
        board.setElement(7, 0, 9);
        board.setElement(0, 1, 8);
        board.setElement(3, 1, 2);
        board.setElement(8, 1, 6);
        board.setElement(1, 2, 3);
        board.setElement(4, 2, 6);
        board.setElement(7, 2, 7);
        board.setElement(2, 3, 1);
        board.setElement(6, 3, 6);
        board.setElement(0, 4, 5);
        board.setElement(1, 4, 4);
        board.setElement(7, 4, 1);
        board.setElement(8, 4, 9);
        board.setElement(2, 5, 2);
        board.setElement(6, 5, 7);
        board.setElement(1, 6, 9);
        board.setElement(4, 6, 3);
        board.setElement(7, 6, 8);
        board.setElement(0, 7, 2);
        board.setElement(3, 7, 8);
        board.setElement(8, 7, 7);
        board.setElement(5, 7, 4);
        board.setElement(1, 8, 1);
        board.setElement(3, 8, 9);
        board.setElement(5, 8, 7);
        board.setElement(7, 8, 6);

        board.setElement(0, 0, 4);

        //when
       try {
           solver.solveSudoku();
       } catch (InvalidSudokuException e) {
           throw new RuntimeException(e);
       }
       boolean testForEmptyCells = board.getSudokuBoard().stream().flatMap(s -> s.getSudokuRow().
                stream()).collect(Collectors.toList()).stream().anyMatch(s -> s.getCurrentSudokuElementValue() == -1);
        //then
        Assertions.assertFalse(testForEmptyCells);
        System.out.println(board);

    }

    @Test
    void testSolveEmptySudoku(){
        SudokuBoard board = new SudokuBoard();
        board.generateEmptyBoard();
        SudokuSolver solver=new SudokuSolver(board);
        try {
            solver.solveSudoku();
        } catch (InvalidSudokuException e) {
            throw new RuntimeException(e);
        }
        board=solver.getGameBoard();
        System.out.println(board);
    }

    @Test
    void testForInvalidSudoku(){
        SudokuBoard board = new SudokuBoard();
        board.generateEmptyBoard();
        SudokuSolver solver=new SudokuSolver(board);
        board.setElement(0, 0, 2);
        board.setElement(1, 0, 2);


        Throwable exception = Assertions.assertThrows(InvalidSudokuException.class, solver::solveSudoku);
        Assertions.assertEquals("Invalid Sudoku", exception.getMessage());
    }


}

package com.kodilla.sudoku;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SudokuTestingSuite {
    @Test
    public void testPrinting()
    {   //given
        SudokuBoard board=new SudokuBoard(9);
        board.generateEmptyBoard();
        //when
        //then
        System.out.println(board);
    }

    @Test
    public void testSettingSingleElement()
    {
        //given
        SudokuBoard board=new SudokuBoard(9);
        board.generateEmptyBoard();
        //when
        board.setElement(3,1,7);
        SudokuElement tempElement=board.getElement(1,3);
        //then
        Assertions.assertEquals(tempElement.getCurrentFieldValue(),7);
        System.out.println(board);
    }



    @Test
    public void testRemoveElementFromPossibleValuesRow()
    {
        //given
        SudokuGame game=new SudokuGame(9);
        //when
        game.getGameBoard().setElement(0,0,6);
        game.sudokuSolver();
        SudokuElement tempElement=game.getGameBoard().getElement(0,0);
        SudokuElement tempElement2=game.getGameBoard().getElement(0,1);
        //then
        Assertions.assertFalse(tempElement.possibleValues.getPossibleValues().contains(6));
        Assertions.assertFalse(tempElement2.possibleValues.getPossibleValues().contains(6));
        tempElement.possibleValues.printPossibleValues();
    }

    @Test
    public void testRemoveElementFromPossibleValuesRowAndColumn()
    {
        //given
        SudokuGame game=new SudokuGame(9);
        //when
        for (int i=0;i<9;i++){
            game.getGameBoard().setElement(i,0,i+1);
        }
        game.getGameBoard().setElement(1,1,4);
        game.sudokuSolver();
        SudokuElement tempElement=game.getGameBoard().getElement(1,0);
        SudokuElement tempElement2=game.getGameBoard().getElement(1,6);
        //then
        game.PrintGameState();
        Assertions.assertFalse(tempElement.possibleValues.getPossibleValues().contains(3));
        Assertions.assertFalse(tempElement2.possibleValues.getPossibleValues().contains(7));
        Assertions.assertTrue(tempElement.possibleValues.getPossibleValues().contains(8));
        tempElement.possibleValues.printPossibleValues();
    }

    @Test
    public void testWritingLastMissingElementToTheRow()
    {
        //given
        SudokuGame game=new SudokuGame(9);

        //when
          for (int i=2;i<9;i++){
              game.getGameBoard().setElement(i,0,i+1);
          }
        game.getGameBoard().setElement(0,0,2);
        game.sudokuSolver();
        SudokuElement tempElement=game.getGameBoard().getElement(0,0);

        //then
        tempElement.possibleValues.printPossibleValues();
        Assertions.assertEquals(0, tempElement.possibleValues.getPossibleValues().size());
        game.PrintGameState();
    }


    @Test
    public void testWritingMultipleElementsToGameBoard()
    {
        //given
        SudokuGame game=new SudokuGame(9);
        //when
        for (int i=2;i<9;i++){
            game.getGameBoard().setElement(i,0,i+1);
        }
        game.getGameBoard().setElement(0,2,4);
        game.getGameBoard().setElement(1,1,5);
        game.getGameBoard().setElement(1,2,6);
        game.getGameBoard().setElement(2,1,7);
        game.sudokuSolver();
        SudokuElement tempElement=game.getGameBoard().getElement(2,2);
        //then
        tempElement.possibleValues.printPossibleValues();
        Assertions.assertEquals(4, tempElement.possibleValues.getPossibleValues().size());
        game.PrintGameState();
    }

}

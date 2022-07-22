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
        board.setElement(1,3,7);
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
            game.getGameBoard().setElement(0,i,i+1);
        }
        game.getGameBoard().setElement(1,1,3);
        game.sudokuSolver();
        SudokuElement tempElement=game.getGameBoard().getElement(2,1);
        SudokuElement tempElement2=game.getGameBoard().getElement(1,6);
        //then
        Assertions.assertFalse(tempElement.possibleValues.getPossibleValues().contains(3));
        Assertions.assertFalse(tempElement2.possibleValues.getPossibleValues().contains(7));
        tempElement.possibleValues.printPossibleValues();
        game.PrintGameState();
    }

    @Test
    public void testWritingLastMissingElementToTheRow()
    {
        //given
        SudokuGame game=new SudokuGame(9);

        //when
          for (int i=2;i<9;i++){
              game.getGameBoard().setElement(0,i,i+1);
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
            game.getGameBoard().setElement(0,i,i+1);
        }
        game.getGameBoard().setElement(0,0,2);
        game.getGameBoard().setElement(1,8,2);
        game.getGameBoard().setElement(2,8,2);
        game.getGameBoard().setElement(3,8,2);
        game.getGameBoard().setElement(4,8,2);
        game.getGameBoard().setElement(8,0,9);
        game.sudokuSolver();
        SudokuElement tempElement=game.getGameBoard().getElement(0,0);
        //then
        tempElement.possibleValues.printPossibleValues();
        Assertions.assertEquals(0, tempElement.possibleValues.getPossibleValues().size());
        game.PrintGameState();
    }

}

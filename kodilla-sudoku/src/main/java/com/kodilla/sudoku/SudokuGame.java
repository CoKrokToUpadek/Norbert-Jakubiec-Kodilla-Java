package com.kodilla.sudoku;

import com.kodilla.sudoku.algorithms.ValidatorImplementation;

import java.util.stream.Collectors;

public class SudokuGame {

    private SudokuBoard gameBoard;
    private SudokuBoard gameBoardCopy = null;
    private final ValidatorImplementation validator = new ValidatorImplementation();

    public SudokuGame(int size) {
        gameBoard = new SudokuBoard(size);
        gameBoard.generateEmptyBoard();
    }

    public void sudokuSolver()  {
        SudokuElement currentCell;
        boolean actionTaken = true;
        boolean escape=false;
        int tempEscape = 0;
        int validatorOutput = 0;
        SudokuElement guessedCell=new SudokuElement(-1);
        Integer guessedCellValue=0;
        int guessedCellRow=0;
        int guessedCellColumn=0;

        while (!escape) {
            actionTaken = false;
            for (int i = 0; i < gameBoard.getBoardSize(); i++) {
                for (int j = 0; j < gameBoard.getBoardSize(); j++) {
                    currentCell = gameBoard.getSudokuBoard().get(i).getSudokuRow().get(j);
                    if (currentCell.getCurrentFieldValue() == -1) {

                        validatorOutput = validator.checkIfValueIsAlreadyOnBoard(this.gameBoard, i, j, currentCell);
                        if (validatorOutput != -1) {
                            currentCell.setCurrentFieldValue(validatorOutput);
                            actionTaken = true;
                        }

                        validatorOutput = validator.checkIfValueIsOnPossibleValuesList(this.gameBoard, i, j, currentCell);
                        if (validatorOutput != -1) {
                            currentCell.setCurrentFieldValue(validatorOutput);
                            actionTaken = true;
                        }
                    }
                }
            }

            if(!actionTaken){
                outerloop:
                for (int i = 0; i < gameBoard.getBoardSize(); i++) {
                    for (int j = 0; j < gameBoard.getBoardSize(); j++) {
                        guessedCell = gameBoard.getSudokuBoard().get(i).getSudokuRow().get(j);
                        if (guessedCell.getCurrentFieldValue()==-1){
                            guessedCellRow=i;
                            guessedCellColumn=j;
                            break outerloop;
                        }
                    }
                }
                guessedCellValue=guessedCell.possibleValues.getPossibleValues().get(0);
                guessedCell.setCurrentFieldValue(guessedCellValue);
                try {
                    gameBoardCopy=gameBoard.clone();
                } catch (CloneNotSupportedException e) {
                    throw new RuntimeException(e);
                }
            }
            if(validator.isErrorStatus()){
                validator.setErrorStatus(false);
                try {
                    gameBoard=gameBoardCopy.clone();
                } catch (CloneNotSupportedException | NullPointerException e) {
                  if (e instanceof CloneNotSupportedException){
                      throw new RuntimeException(e);
                  }else {
                      System.out.println("invalid sudoku");
                      throw new NullPointerException();
                  }
                }
            }

            if (gameBoard.getSudokuBoard().stream().flatMap(s -> s.getSudokuRow().
                    stream()).collect(Collectors.toList()).stream().noneMatch(s -> s.getCurrentFieldValue() == -1)) {
                    escape=true;
            }
            if (tempEscape==60){
                System.out.println("pause");
            }
            tempEscape++;
        }
    }


    public SudokuBoard getGameBoard() {
        return gameBoard;
    }

    public void PrintGameState() {
        System.out.println(gameBoard);
    }


}

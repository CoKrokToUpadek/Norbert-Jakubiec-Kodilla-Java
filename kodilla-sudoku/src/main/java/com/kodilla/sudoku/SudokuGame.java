package com.kodilla.sudoku;

import com.kodilla.sudoku.algorithms.ValidatorImplementation;

public class SudokuGame {

    private final SudokuBoard gameBoard;
    private final ValidatorImplementation validator = new ValidatorImplementation();

    public SudokuGame(int size) {
        gameBoard = new SudokuBoard(size);
        gameBoard.generateEmptyBoard();
    }

    public void sudokuSolver() {
        SudokuElement currentCell;
        boolean solvingInProgress = true;
        int tempEscape = 0;
        int validatorOutput = 0;
        while (solvingInProgress) {
            solvingInProgress = false;
            for (int i = 0; i < gameBoard.getBoardSize(); i++) {
                for (int j = 0; j < gameBoard.getBoardSize(); j++) {
                    currentCell = gameBoard.getSudokuBoard().get(i).getSudokuRow().get(j);
                    if (currentCell.getCurrentFieldValue() == -1) {
                        solvingInProgress = true;

                        validatorOutput = validator.checkIfValueIsAlreadyOnBoard(this.gameBoard, i, j, currentCell);

                        if (validatorOutput != -1) {
                            currentCell.setCurrentFieldValue(validatorOutput);
                        }

                        validatorOutput=validator.checkIfValueIsOnPossibleValuesList(this.gameBoard, i, j, currentCell);
                        if (validatorOutput != -1) {
                            currentCell.setCurrentFieldValue(validatorOutput);
                        }
                    }
                }
            }
            //temp escape
            if (tempEscape ==40) {
                solvingInProgress = false;
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

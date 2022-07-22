package com.kodilla.sudoku;

public class SudokuGame {

    private SudokuBoard gameBoard;

    public SudokuGame(int size) {
        gameBoard = new SudokuBoard(size);
        gameBoard.generateEmptyBoard();
    }

    public void sudokuSolver() {
        SudokuElement currentCell;
        boolean solvingInProgress = true;
        boolean fullFirstRunMade = false;
        int tempEscape = 0;

        while (solvingInProgress) {
            solvingInProgress = false;
            for (int i = 0; i < gameBoard.getBoardSize(); i++) {
                for (int j = 0; j < gameBoard.getBoardSize(); j++) {
                    //operating on single element
                    currentCell = gameBoard.getSudokuBoard().get(i).getSudokuRow().get(j);
                    //if there is a value here
                    if (currentCell.getCurrentFieldValue() != -1) {
                        solvingInProgress = true;
                        //I remove every single instance of that number from every single list in this row
                        removeElementFromRow(i, currentCell);
                        removeElementFromColumn(j, currentCell);
                        removeElementFrom3x3(i, j, currentCell);

                    } else {
                        //If there is only 1 element left I write it into the cell
                        if (currentCell.possibleValues.getPossibleValues().size() == 1) {
                            currentCell.setCurrentFieldValue(currentCell.possibleValues.getPossibleValues().get(0));
                            //removing last element from every single cell in row
                            for (int k = 0; k < gameBoard.getBoardSize(); k++) {
                                gameBoard.getSudokuBoard().get(i).getSudokuRow().get(k).possibleValues.removeValue(currentCell.getCurrentFieldValue());
                            }
                        } else {
                            //write first random
                            if (fullFirstRunMade) {
                             /*  currentCell.setCurrentFieldValue(currentCell.possibleValues.getPossibleValues().get(0));
                               for (int k=0;k< gameBoard.getBoardSize();k++) {
                                   gameBoard.getSudokuBoard().get(i).getSudokuRow().get(k).possibleValues.removeValue(currentCell.getCurrentFieldValue());
                               }*/
                            }

                        }
                    }
                }
            }
            fullFirstRunMade = true;
            //temp escape
            if (tempEscape == 10) {
                solvingInProgress = false;
            }
            tempEscape++;
        }
    }

    public void removeElementFromRow(int row, SudokuElement currentCell) {
        for (int k = 0; k < gameBoard.getBoardSize(); k++) {
            gameBoard.getSudokuBoard().get(row).getSudokuRow().get(k).possibleValues.removeValue(currentCell.getCurrentFieldValue());
        }
    }

    public void removeElementFromColumn(int column, SudokuElement currentCell) {
        for (int k = 0; k < gameBoard.getBoardSize(); k++) {
            gameBoard.getSudokuBoard().get(k).getSudokuRow().get(column).possibleValues.removeValue(currentCell.getCurrentFieldValue());
        }
    }

    public void removeElementFrom3x3(int column, int row, SudokuElement currentCell) {

        int startX;
        int startY;
        if (column < 3) {
            startY=0;
        } else if (column < 6) {
            startY = 3;
        } else {
            startY = 6;
        }

        if (row < 3) {
            startX=0;
        } else if (row < 6) {
            startX = 3;
        } else {
            startX = 6;
        }

        for (int i = startY; i < startY + 3; i++) {
            for (int j = startX; j < startX + 3; j++) {
                gameBoard.getSudokuBoard().get(i).getSudokuRow().get(j).possibleValues.removeValue(currentCell.getCurrentFieldValue());
            }
        }
    }


    public SudokuBoard getGameBoard() {
        return gameBoard;
    }

    public void PrintGameState() {
        System.out.println(gameBoard);
    }


}

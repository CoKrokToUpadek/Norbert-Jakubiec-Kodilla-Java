package com.kodilla.sudoku2;

import java.util.ArrayList;
import java.util.List;

public class SudokuBoard extends Prototype<SudokuBoard> {
    private List<SudokuRow> sudokuBoard = new ArrayList<>();
    private final int boardSize = 9;

    public SudokuBoard() {
    }

    public void generateEmptyBoard() {
        for (int i = 0; i < boardSize; i++) {
            sudokuBoard.add(new SudokuRow());
            for (int j = 0; j < boardSize; j++) {
                sudokuBoard.get(i).getSudokuRow().add(new SudokuElement());
            }
        }
    }

    public void setElement(int columnIndex, int rowIndex, int value) {
        SudokuElement tempElement = sudokuBoard.get(rowIndex).getSudokuRow().get(columnIndex);
        tempElement.setCurrentSudokuElementValue(value);
        tempElement.removeElementFromPossibleValuesByValue(value);

    }


    public SudokuElement getElement(int rowIndex, int columnIndex) {
        return sudokuBoard.get(rowIndex).getSudokuRow().get(columnIndex);
    }

    public int getBoardSize() {
        return boardSize;
    }

    public List<SudokuRow> getSudokuBoard() {
        return sudokuBoard;
    }

    @Override
    public SudokuBoard clone() throws CloneNotSupportedException {
        SudokuBoard clonedBoard = super.clone();
        clonedBoard.sudokuBoard = new ArrayList<>();
        for (SudokuRow row : this.sudokuBoard) {
            clonedBoard.sudokuBoard.add(row.SudokuRowCopy());
        }
        return clonedBoard;
    }

    @Override
    public String toString() {
        StringBuilder sudokuBoardString = new StringBuilder();
        int tempSudokuCellValue;
        sudokuBoardString.append(" ");
        for (int i = 0; i < boardSize; i++) {
            sudokuBoardString.append(" ").append(i);
        }
        sudokuBoardString.append("\n");
        for (int i = 0; i < boardSize; i++) {
            sudokuBoardString.append("  ").append("_".repeat(boardSize * 2)).append("\n");
            sudokuBoardString.append(i).append("|");
            for (int j = 0; j < boardSize; j++) {
                tempSudokuCellValue = sudokuBoard.get(i).getSudokuRow().get(j).getCurrentSudokuElementValue();
                if (tempSudokuCellValue == -1) {
                    sudokuBoardString.append(" |");
                } else {
                    sudokuBoardString.append(tempSudokuCellValue).append("|");
                }
            }
            sudokuBoardString.append("\n");
        }
        sudokuBoardString.append("  ").append("_".repeat(boardSize * 2)).append("\n");
        return sudokuBoardString.toString();
    }
}

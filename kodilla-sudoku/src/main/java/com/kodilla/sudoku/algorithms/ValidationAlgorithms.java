package com.kodilla.sudoku.algorithms;

import com.kodilla.sudoku.SudokuBoard;
import com.kodilla.sudoku.SudokuElement;

public interface ValidationAlgorithms {
    int checkIfValueIsAlreadyOnBoard(SudokuBoard board, int row, int column, SudokuElement currentCell);
    int checkIfValueIsOnPossibleValuesList(SudokuBoard board, int row, int column, SudokuElement currentCell);
    boolean checkIfLastPossibleValueIsElsewhere(SudokuBoard board, int row, int column, SudokuElement currentCell);
}

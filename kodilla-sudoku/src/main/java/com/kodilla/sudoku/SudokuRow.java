package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuRow {
    private List<SudokuElement> sudokuRow;

    public SudokuRow() {
        sudokuRow=new ArrayList<>();
    }

    public List<SudokuElement> getSudokuRow() {
        return sudokuRow;
    }
}

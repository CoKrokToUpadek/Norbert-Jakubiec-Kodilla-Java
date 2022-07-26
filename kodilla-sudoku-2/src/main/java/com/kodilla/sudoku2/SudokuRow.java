package com.kodilla.sudoku2;

import java.util.ArrayList;
import java.util.List;

public class SudokuRow {
    private final List<SudokuElement> sudokuRow = new ArrayList<>();

    public SudokuRow() {
    }

    public List<SudokuElement> getSudokuRowClonedList(List<SudokuElement> sudokuRow) {
        List<SudokuElement> copy = new ArrayList<>();
        for (SudokuElement element : sudokuRow) {
            copy.add(new SudokuElement(element));
        }
        return copy;
    }

    public SudokuRow SudokuRowCopy() {
        SudokuRow rowCopy = new SudokuRow();
        rowCopy.getSudokuRow().addAll(getSudokuRowClonedList(sudokuRow));
        return rowCopy;
    }

    public List<SudokuElement> getSudokuRow() {
        return sudokuRow;
    }
}

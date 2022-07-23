package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuRow {
    private List<SudokuElement> sudokuRow;

    public SudokuRow() {
        sudokuRow=new ArrayList<>();
    }

    public List<SudokuElement> getSudokuRowClonedList(){
        List<SudokuElement> copy=new ArrayList<>();
        for (SudokuElement element:sudokuRow){
            copy.add(new SudokuElement(element));
        }
        return copy;
    }

    public SudokuRow SudokuRowCopy(){
        SudokuRow rowCopy=new SudokuRow();
        rowCopy.getSudokuRowClonedList();
        return rowCopy;
    }


    public List<SudokuElement> getSudokuRow() {
        return sudokuRow;
    }
}

package com.kodilla.sudoku;


public class SudokuElement {
    private int currentFieldValue;
    public SudokuPossibleFieldValues possibleValues;

    public SudokuElement(int currentFieldValue) {
        this.currentFieldValue = currentFieldValue;
        possibleValues=new SudokuPossibleFieldValues();
    }

    public void setCurrentFieldValue(int currentFieldValue) {
        this.currentFieldValue = currentFieldValue;
    }

    public int getCurrentFieldValue() {
        return currentFieldValue;
    }
}

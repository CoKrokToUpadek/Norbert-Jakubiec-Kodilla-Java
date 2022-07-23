package com.kodilla.sudoku;


public class SudokuElement {
    private int currentFieldValue;
    public SudokuPossibleFieldValues possibleValues;

    public SudokuElement(int currentFieldValue) {
        this.currentFieldValue = currentFieldValue;
        possibleValues=new SudokuPossibleFieldValues();
        possibleValues.removeValue(currentFieldValue);
    }

    public SudokuElement(SudokuElement element){
        this.currentFieldValue=element.getCurrentFieldValue();
        this.possibleValues=new SudokuPossibleFieldValues(element.possibleValues);
    }


    public void setCurrentFieldValue(int currentFieldValue) {
        if (currentFieldValue==-1){
            this.currentFieldValue = currentFieldValue;
        }else {
            this.currentFieldValue = currentFieldValue;
            possibleValues.removeValue(currentFieldValue);
        }
    }

    public int getCurrentFieldValue() {
        return currentFieldValue;
    }
}

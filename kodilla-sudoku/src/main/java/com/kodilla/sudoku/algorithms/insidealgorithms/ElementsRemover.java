package com.kodilla.sudoku.algorithms.insidealgorithms;

import com.kodilla.sudoku.SudokuElement;

public class ElementsRemover implements ValidatorInsideMethodInterface{
    @Override
    public int InsideMethodImplementation(SudokuElement currentElement, SudokuElement tempElement, int currentlyCheckedValue) {
        if (tempElement!=currentElement && tempElement.getCurrentFieldValue()!=-1){
            if (tempElement.getCurrentFieldValue()==currentlyCheckedValue){
                currentElement.possibleValues.removeValue(currentlyCheckedValue);
                return 1;
            }
        }
        return 0;
    }
}

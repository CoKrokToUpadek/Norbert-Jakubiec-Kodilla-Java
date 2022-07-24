package com.kodilla.sudoku.algorithms.insidealgorithms;

import com.kodilla.sudoku.SudokuElement;

public class ValueOnBoardChecker implements ValidatorInsideMethodInterface{
    @Override
    public int InsideMethodImplementation(SudokuElement currentElement, SudokuElement tempElement, int currentlyCheckedValue) {
        if (tempElement != currentElement && tempElement.getCurrentFieldValue()!=-1) {
            if(tempElement.getCurrentFieldValue()==currentElement.possibleValues.getPossibleValues().get(0)){
                return 1;
            }
        }
        return 0;
    }
}

package com.kodilla.sudoku.algorithms.insidealgorithms;

import com.kodilla.sudoku.SudokuElement;

public class PossibleValuesListChecker implements ValidatorInsideMethodInterface{
    @Override
    public int InsideMethodImplementation(SudokuElement currentElement, SudokuElement tempElement, int currentlyCheckedValue) {
        if (tempElement != currentElement && tempElement.getCurrentFieldValue() == -1) {
            if(tempElement.possibleValues.getPossibleValues().contains(currentlyCheckedValue)){
                return 1;
            }
        }
        return 0;
    }
}

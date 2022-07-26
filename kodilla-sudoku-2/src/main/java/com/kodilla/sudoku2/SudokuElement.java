package com.kodilla.sudoku2;

import java.util.ArrayList;
import java.util.List;

public class SudokuElement {
    public static int EMPTY = -1;
    private int currentSudokuElementValue;
    private final List<Integer> possibleSudokuElementValues;

    public SudokuElement() {
        this.currentSudokuElementValue = SudokuElement.EMPTY;
        possibleSudokuElementValues = new ArrayList<>(SudokuPossibleValuesReference.VALUESREFTABLE);
    }

    //for copy
    public SudokuElement(SudokuElement element) {
        this.currentSudokuElementValue = element.getCurrentSudokuElementValue();
        this.possibleSudokuElementValues = new ArrayList<>(element.getPossibleSudokuElementValues());
    }

    public void removeElementFromPossibleValuesByValue(Integer i) {
        this.possibleSudokuElementValues.remove(i);
    }


    public void setCurrentSudokuElementValue(int newSudokuElementValue) {
        if (SudokuPossibleValuesReference.VALUESREFTABLE.contains(newSudokuElementValue) || newSudokuElementValue == SudokuElement.EMPTY) {
            this.currentSudokuElementValue = newSudokuElementValue;
        } else {
            System.out.println("you cant put that there!");
        }
    }

    public int getCurrentSudokuElementValue() {
        return currentSudokuElementValue;
    }

    public List<Integer> getPossibleSudokuElementValues() {
        return possibleSudokuElementValues;
    }

    public void printPossibleSudokuValues() {
        possibleSudokuElementValues.forEach(n -> System.out.print(n + "/"));
    }
}

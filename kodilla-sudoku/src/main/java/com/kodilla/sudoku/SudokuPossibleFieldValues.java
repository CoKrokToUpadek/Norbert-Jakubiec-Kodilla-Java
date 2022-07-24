package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuPossibleFieldValues {
    private List<Integer> possibleValues;

    public SudokuPossibleFieldValues() {
        possibleValues=new ArrayList<>();
        for(int i=1;i<10;i++){
            possibleValues.add(i);
        }
    }

    public SudokuPossibleFieldValues(SudokuPossibleFieldValues values){
        this.possibleValues=new ArrayList<>(values.possibleValues);
    }

    public void removeValue(Integer i){
        possibleValues.remove(i);

    }

    public List<Integer> getPossibleValues() {
        return possibleValues;
    }

    public void printPossibleValues(){
        possibleValues.forEach(n->System.out.print(n+"/"));
    }
}

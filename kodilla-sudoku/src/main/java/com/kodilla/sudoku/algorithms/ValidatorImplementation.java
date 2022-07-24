package com.kodilla.sudoku.algorithms;

import com.kodilla.sudoku.SudokuBoard;
import com.kodilla.sudoku.SudokuElement;
import com.kodilla.sudoku.algorithms.insidealgorithms.ElementsRemover;
import com.kodilla.sudoku.algorithms.insidealgorithms.PossibleValuesListChecker;
import com.kodilla.sudoku.algorithms.insidealgorithms.ValidatorInsideMethodInterface;
import com.kodilla.sudoku.algorithms.insidealgorithms.ValueOnBoardChecker;

public class ValidatorImplementation implements ValidationAlgorithms {


    private boolean errorStatus=false;

    @Override
    public int checkIfValueIsAlreadyOnBoard(SudokuBoard board, int row, int column, SudokuElement currentCell) {
        for(int i=1;i<=9;i++) {
            if (currentCell.possibleValues.getPossibleValues().size()==1){
                if (checkIfLastPossibleValueIsElsewhere(board, row, column, currentCell)){
                    errorStatus=true;
                }
            }
            checkerRow(board,row,currentCell,i,new ElementsRemover());
            checkerColumn(board,column,currentCell,i, new ElementsRemover());
            checker3x3(board,column,row,currentCell,i,new ElementsRemover());
        }
        if (currentCell.possibleValues.getPossibleValues().size()==1){
            return currentCell.possibleValues.getPossibleValues().get(0);
        }
        return -1;
    }


    @Override
    public int checkIfValueIsOnPossibleValuesList(SudokuBoard board, int row, int column, SudokuElement currentCell) {
        for(int tempValue: currentCell.possibleValues.getPossibleValues()) {
            if( !checkerRow(board,row,currentCell,tempValue, new PossibleValuesListChecker()) ||
                    !checkerColumn(board,column,currentCell,tempValue, new PossibleValuesListChecker()) ||
                    !checker3x3(board,column,row,currentCell,tempValue, new PossibleValuesListChecker())){
                return tempValue;
            }
        }
        return -1;
    }


    @Override
    public boolean checkIfLastPossibleValueIsElsewhere(SudokuBoard board, int row, int column, SudokuElement currentCell) {
        if (currentCell.possibleValues.getPossibleValues().size()==1){
            return checkerRow(board, row, currentCell,0, new ValueOnBoardChecker())||
                    checkerColumn(board, column, currentCell,0, new ValueOnBoardChecker()) ||
                    checker3x3(board, column, row, currentCell,0, new ValueOnBoardChecker());
        }
        return false;
    }

    private boolean checkerRow(SudokuBoard gameBoard, int row, SudokuElement currentCell, int currentlyCheckedValue, ValidatorInsideMethodInterface method) {
        for (int k = 0; k < gameBoard.getBoardSize(); k++) {
            SudokuElement tempElement = gameBoard.getSudokuBoard().get(row).getSudokuRow().get(k);
            if( method.InsideMethodImplementation(currentCell,tempElement,currentlyCheckedValue)==1){
                return true;
            }

        }
        return false;
    }

    private boolean checkerColumn(SudokuBoard gameBoard,int column, SudokuElement currentCell,int currentlyCheckedValue,ValidatorInsideMethodInterface method) {
        for (int k = 0; k < gameBoard.getBoardSize(); k++) {
            SudokuElement tempElement = gameBoard.getSudokuBoard().get(k).getSudokuRow().get(column);
            if (method.InsideMethodImplementation(currentCell,tempElement,currentlyCheckedValue)==1){
                return true;
            }

        }
        return false;
    }

    private boolean checker3x3(SudokuBoard gameBoard,int column, int row, SudokuElement currentCell,int currentlyCheckedValue,ValidatorInsideMethodInterface method) {

        int startColum=rowAndColumnStartCalc(column);
        int startRow=rowAndColumnStartCalc(row);

        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startColum; j < startColum + 3; j++) {
                SudokuElement tempElement= gameBoard.getSudokuBoard().get(i).getSudokuRow().get(j);
                if ( method.InsideMethodImplementation(currentCell,tempElement,currentlyCheckedValue)==1){
                    return true;
                }
            }
        }
        return false;
    }


    int rowAndColumnStartCalc(int value){
        if (value< 3) {
            return 0;
        } else if (value < 6) {
            return  3;
        } else {
            return  6;
        }
    }

    public boolean isErrorStatus() {
        return errorStatus;
    }

    public void setErrorStatus(boolean errorStatus) {
        this.errorStatus = errorStatus;
    }
}

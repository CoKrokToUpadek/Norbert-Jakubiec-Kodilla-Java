package com.kodilla.sudoku.algorithms.insidealgorithms;

import com.kodilla.sudoku.SudokuBoard;
import com.kodilla.sudoku.SudokuElement;

public class LegacySudokuAlgorithms {
    private boolean errorStatus=false;


    public int checkIfValueIsAlreadyOnBoard(SudokuBoard board, int row, int column, SudokuElement currentCell) {
        for(int i=1;i<=9;i++) {
            if (currentCell.possibleValues.getPossibleValues().size()==1){
                if (checkIfLastPossibleValueIsElsewhere(board, row, column, currentCell)){
                    System.out.println("error");
                    errorStatus=true;

                }
            }
            removeElementFromRow(board,row,currentCell,i);
            removeElementFromColumn(board,column,currentCell,i);
            removeElementFrom3x3(board,column,row,currentCell,i);
        }
        if (currentCell.possibleValues.getPossibleValues().size()==1){
            return currentCell.possibleValues.getPossibleValues().get(0);
        }
        return -1;
    }



    public int checkIfValueIsOnPossibleValuesList(SudokuBoard board, int row, int column, SudokuElement currentCell) {
        for(int tempValue: currentCell.possibleValues.getPossibleValues()) {
            if( !checkPossibleValuesListInRow(board,row,currentCell,tempValue) ||
                    !checkPossibleValuesListInColumn(board,column,currentCell,tempValue) ||
                    !checkPossibleValuesListIn3x3(board,column,row,currentCell,tempValue)){
                return tempValue;
            }
        }
        return -1;
    }



    public boolean checkIfLastPossibleValueIsElsewhere(SudokuBoard board, int row, int column, SudokuElement currentCell) {
        if (currentCell.possibleValues.getPossibleValues().size()==1){
            return checkValueExistenceInRow(board, row, currentCell) ||
                    checkValueExistenceInColumn(board, column, currentCell) ||
                    checkValueExistenceIn3x3(board, column, row, currentCell);
        }
        return false;
    }

    private boolean checkValueExistenceInRow(SudokuBoard gameBoard, int row, SudokuElement currentCell) {
        for (int k = 0; k < gameBoard.getBoardSize(); k++) {
            SudokuElement tempElement = gameBoard.getSudokuBoard().get(row).getSudokuRow().get(k);
            if (tempElement != currentCell && tempElement.getCurrentFieldValue()!=-1) {
                if(tempElement.getCurrentFieldValue()==currentCell.possibleValues.getPossibleValues().get(0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkValueExistenceInColumn(SudokuBoard gameBoard,int column, SudokuElement currentCell) {
        for (int k = 0; k < gameBoard.getBoardSize(); k++) {
            SudokuElement tempElement = gameBoard.getSudokuBoard().get(k).getSudokuRow().get(column);
            if (tempElement != currentCell&& tempElement.getCurrentFieldValue()!=-1) {
                if(tempElement.getCurrentFieldValue()==currentCell.possibleValues.getPossibleValues().get(0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkValueExistenceIn3x3(SudokuBoard gameBoard,int column, int row, SudokuElement currentCell) {

        int startColum=rowAndColumnStartCalc(column);
        int startRow=rowAndColumnStartCalc(row);

        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startColum; j < startColum + 3; j++) {
                SudokuElement tempElement= gameBoard.getSudokuBoard().get(i).getSudokuRow().get(j);
                if (tempElement!=currentCell&& tempElement.getCurrentFieldValue()!=-1){
                    if(tempElement.getCurrentFieldValue()==currentCell.possibleValues.getPossibleValues().get(0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }



    private boolean checkPossibleValuesListInRow(SudokuBoard gameBoard, int row, SudokuElement currentCell, int currentlyCheckedValue) {
        for (int k = 0; k < gameBoard.getBoardSize(); k++) {
            SudokuElement tempElement = gameBoard.getSudokuBoard().get(row).getSudokuRow().get(k);
            if (tempElement != currentCell && tempElement.getCurrentFieldValue() == -1) {
                if(tempElement.possibleValues.getPossibleValues().contains(currentlyCheckedValue)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkPossibleValuesListInColumn(SudokuBoard gameBoard,int column, SudokuElement currentCell, int currentlyCheckedValue) {
        for (int k = 0; k < gameBoard.getBoardSize(); k++) {
            SudokuElement tempElement = gameBoard.getSudokuBoard().get(k).getSudokuRow().get(column);
            if (tempElement != currentCell && tempElement.getCurrentFieldValue() == -1) {
                if(tempElement.possibleValues.getPossibleValues().contains(currentlyCheckedValue)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkPossibleValuesListIn3x3(SudokuBoard gameBoard,int column, int row, SudokuElement currentCell, int currentlyCheckedValue) {

        int startColum=rowAndColumnStartCalc(column);
        int startRow=rowAndColumnStartCalc(row);

        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startColum; j < startColum + 3; j++) {
                SudokuElement tempElement= gameBoard.getSudokuBoard().get(i).getSudokuRow().get(j);
                if (tempElement!=currentCell && tempElement.getCurrentFieldValue()==-1){
                    if(tempElement.possibleValues.getPossibleValues().contains(currentlyCheckedValue)){
                        return true;
                    }
                }
            }
        }
        return false;
    }


    private void removeElementFromRow(SudokuBoard gameBoard, int row, SudokuElement currentCell, int currentlyCheckedValue) {
        for (int k = 0; k < gameBoard.getBoardSize(); k++) {
            SudokuElement tempElement=gameBoard.getSudokuBoard().get(row).getSudokuRow().get(k);
            if (tempElement!=currentCell && tempElement.getCurrentFieldValue()!=-1){
                if (tempElement.getCurrentFieldValue()==currentlyCheckedValue){
                    currentCell.possibleValues.removeValue(currentlyCheckedValue);
                }
            }
        }
    }

    private void removeElementFromColumn(SudokuBoard gameBoard,int column, SudokuElement currentCell, int currentlyCheckedValue) {
        for (int k = 0; k < gameBoard.getBoardSize(); k++) {
            SudokuElement tempElement=gameBoard.getSudokuBoard().get(k).getSudokuRow().get(column);
            if (tempElement!=currentCell && tempElement.getCurrentFieldValue()!=-1){
                if (tempElement.getCurrentFieldValue()==currentlyCheckedValue){
                    currentCell.possibleValues.removeValue(currentlyCheckedValue);
                }
            }
        }
    }

    private void removeElementFrom3x3(SudokuBoard gameBoard,int column, int row, SudokuElement currentCell, int currentlyCheckedValue) {

        int startColum=rowAndColumnStartCalc(column);
        int startRow=rowAndColumnStartCalc(row);

        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startColum; j < startColum + 3; j++) {
                SudokuElement tempElement= gameBoard.getSudokuBoard().get(i).getSudokuRow().get(j);
                if (tempElement!=currentCell && tempElement.getCurrentFieldValue()!=-1){
                    if (tempElement.getCurrentFieldValue()==currentlyCheckedValue){
                        currentCell.possibleValues.removeValue(currentlyCheckedValue);
                    }
                }
            }
        }
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

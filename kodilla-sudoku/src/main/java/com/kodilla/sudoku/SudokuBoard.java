package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuBoard extends Prototype<SudokuBoard>{
    List<SudokuRow> sudokuBoard;
    private int boardSize;

    public SudokuBoard(int boardSize) {
        sudokuBoard = new ArrayList<>();
        this.boardSize = boardSize;
    }

    public void generateEmptyBoard() {
        for (int i = 0; i < boardSize; i++) {
            sudokuBoard.add(new SudokuRow());
            for (int j = 0; j < boardSize; j++) {
                sudokuBoard.get(i).getSudokuRow().add(new SudokuElement(-1));
            }
        }
    }

    public void setElement(int columnIndex, int rowIndex, int value){
        sudokuBoard.get(rowIndex).getSudokuRow().get(columnIndex).setCurrentFieldValue(value);
    }
    public SudokuElement getElement(int rowIndex, int columnIndex){
      return sudokuBoard.get(rowIndex).getSudokuRow().get(columnIndex);
    }

    public int getBoardSize() {
        return boardSize;
    }

    public List<SudokuRow> getSudokuBoard() {
        return sudokuBoard;
    }

    @Override
    public SudokuBoard clone() throws CloneNotSupportedException {
        SudokuBoard clonedBoard=super.clone();
        clonedBoard.sudokuBoard=new ArrayList<>();
        for (SudokuRow row:this.sudokuBoard){
            clonedBoard.sudokuBoard.add(row.SudokuRowCopy());
        }
        return clonedBoard;
    }

    @Override
    public String toString() {
        String sudokuBoardString = "";
        int tempSudokuCellValue;
        sudokuBoardString+=" ";
        for (int i=0;i<boardSize;i++){
            sudokuBoardString+=" "+i;
        }
        sudokuBoardString+="\n";
        for (int i = 0; i < boardSize; i++) {
            sudokuBoardString+="  "+"_".repeat(boardSize*2)+"\n";
            sudokuBoardString += (i) + "|";
            for (int j = 0; j < boardSize; j++) {
                tempSudokuCellValue = sudokuBoard.get(i).getSudokuRow().get(j).getCurrentFieldValue();
                if (tempSudokuCellValue == -1) {
                    sudokuBoardString += " |";
                } else {
                    sudokuBoardString += tempSudokuCellValue + "|";
                }
            }
            sudokuBoardString += "\n";
        }
        sudokuBoardString+="  "+"_".repeat(boardSize*2)+"\n";
        return sudokuBoardString;
    }
}

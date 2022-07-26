package com.kodilla.sudoku2;

public class BackTrackObject {
    SudokuBoard boardCopy;
    private final int rowOfLastGuessedElement;
    private final int columnOfLastGuessedElement;
    private final int valueOfLastGuestElement;

    int deadLock;


    public BackTrackObject(SudokuBoard boardCopy, int rowOfLastGuessedElement, int columnOfLastGuessedElement, int valueOfLastGuestElement) {
        this.boardCopy = boardCopy;
        this.rowOfLastGuessedElement = rowOfLastGuessedElement;
        this.columnOfLastGuessedElement = columnOfLastGuessedElement;
        this.valueOfLastGuestElement = valueOfLastGuestElement;
        this.deadLock = 0;
    }

    public int getDeadLock() {
        return deadLock;
    }

    public void setDeadLock(int deadLock) {
        this.deadLock = deadLock;
    }

    public void decrementDeadLock() {
        this.deadLock--;
    }

    public SudokuBoard getBoardCopy() {
        return boardCopy;
    }

    public int getRowOfLastGuessedElement() {
        return rowOfLastGuessedElement;
    }

    public int getColumnOfLastGuessedElement() {
        return columnOfLastGuessedElement;
    }

    public int getValueOfLastGuestElement() {
        return valueOfLastGuestElement;
    }
}

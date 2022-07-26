package com.kodilla.sudoku2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SudokuSolver {

    SudokuBoard gameBoard;
    SudokuBoard gameBoardCopy;
    List<BackTrackObject> backTrackObjectList;
    boolean actionWasTaken = false;


    public SudokuSolver(SudokuBoard gameBoard) {
        this.gameBoard = gameBoard;
        backTrackObjectList = new ArrayList<>();
    }


    public void validateElementsAndCheckForException() throws BacktrackSudokuException, InvalidSudokuException {
        this.actionWasTaken = false;
        for (int row = 0; row < gameBoard.getBoardSize(); row++) {
            for (int column = 0; column < gameBoard.getBoardSize(); column++) {
                SudokuElement currentElement = gameBoard.getElement(row, column);
                rowChecker(row, currentElement);
                columnChecker(column, currentElement);
                squareChecker(column, row, currentElement);
                checkForLastElementInPossibleNumbers(column, row, currentElement);

            }
        }
    }


    public void guessSudokuElementValue() {
        for (int guesserRow = 0; guesserRow < gameBoard.getBoardSize(); guesserRow++) {
            for (int guesserColumn = 0; guesserColumn < gameBoard.getBoardSize(); guesserColumn++) {
                SudokuElement currentElement = gameBoard.getElement(guesserRow, guesserColumn);
                if (currentElement.getCurrentSudokuElementValue() == -1) {
                    currentElement.setCurrentSudokuElementValue(currentElement.getPossibleSudokuElementValues().get(0));
                    try {
                        gameBoardCopy = gameBoard.clone();
                    } catch (CloneNotSupportedException e) {
                        throw new RuntimeException(e);
                    }
                    createBackTrack(guesserRow, guesserColumn, currentElement.getCurrentSudokuElementValue(), gameBoardCopy);
                    return;
                }
            }
        }
    }


    public SudokuBoard getGameBoard() {
        return gameBoard;
    }

    public void solveSudoku() throws InvalidSudokuException {
        boolean sudokuWasSovled = false;

        while (!sudokuWasSovled) {
            try {
                validateElementsAndCheckForException();
            } catch (BacktrackSudokuException e) {
                returnToBackTrack();
            } catch (InvalidSudokuException e) {
                throw new InvalidSudokuException("Invalid Sudoku");
            }
            if (!this.actionWasTaken) {
                guessSudokuElementValue();
            }
            if (gameBoard.getSudokuBoard().stream().flatMap(s -> s.getSudokuRow().
                    stream()).collect(Collectors.toList()).stream().noneMatch(s -> s.getCurrentSudokuElementValue() == -1)) {
                sudokuWasSovled = true;
            }

        }

    }

    private void createBackTrack(int row, int column, int value, SudokuBoard board) {
        BackTrackObject backTrackObject = new BackTrackObject(board, row, column, value);
        this.backTrackObjectList.add(backTrackObject);
        SudokuElement tempElement = backTrackObject.getBoardCopy().getElement(row, column);
        backTrackObjectList.get(backTrackObjectList.size() - 1).setDeadLock(tempElement.getPossibleSudokuElementValues().size());
    }

    private void returnToBackTrack() {
        BackTrackObject backTrackObject = null;
        boolean searcher = true;
        while (searcher) {
            backTrackObject = backTrackObjectList.get(backTrackObjectList.size() - 1);
            if (backTrackObject.getDeadLock() <= 0) {
                backTrackObjectList.remove(backTrackObjectList.size() - 1);
            } else {
                searcher = false;
            }
        }
        backTrackObject.decrementDeadLock();

        try {
            gameBoard = backTrackObject.getBoardCopy().clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        SudokuElement element = gameBoard.getElement(backTrackObject.getRowOfLastGuessedElement(), backTrackObject.getColumnOfLastGuessedElement());
        element.removeElementFromPossibleValuesByValue(element.getCurrentSudokuElementValue());
        element.setCurrentSudokuElementValue(SudokuElement.EMPTY);
    }


    private void rowChecker(int row, SudokuElement currentElement) throws BacktrackSudokuException, InvalidSudokuException {
        for (int rowCheckerIterator = 0; rowCheckerIterator < gameBoard.getBoardSize(); rowCheckerIterator++) {
            SudokuElement tempElement = gameBoard.getSudokuBoard().get(row).getSudokuRow().get(rowCheckerIterator);
            dataValidator(currentElement, tempElement);
        }
    }

    private void columnChecker(int column, SudokuElement currentElement) throws BacktrackSudokuException, InvalidSudokuException {
        for (int columnCheckerIterator = 0; columnCheckerIterator < gameBoard.getBoardSize(); columnCheckerIterator++) {
            SudokuElement tempElement = gameBoard.getSudokuBoard().get(columnCheckerIterator).getSudokuRow().get(column);
            dataValidator(currentElement, tempElement);

        }
    }

    private void squareChecker(int column, int row, SudokuElement currentElement) throws BacktrackSudokuException, InvalidSudokuException {

        int startColum = rowAndColumnStartCalc(column);
        int startRow = rowAndColumnStartCalc(row);

        for (int squareCheckerIteratorRow = startRow; squareCheckerIteratorRow < startRow + 3; squareCheckerIteratorRow++) {
            for (int squareCheckerIteratorColumn = startColum; squareCheckerIteratorColumn < startColum + 3; squareCheckerIteratorColumn++) {
                SudokuElement tempElement = gameBoard.getSudokuBoard().get(squareCheckerIteratorRow).getSudokuRow().get(squareCheckerIteratorColumn);
                dataValidator(currentElement, tempElement);

            }
        }
    }

    public void dataValidator(SudokuElement currentElement, SudokuElement tempElement) throws BacktrackSudokuException, InvalidSudokuException {

        if (currentElement.getCurrentSudokuElementValue() == -1) {
            if (currentElement.getPossibleSudokuElementValues().size() == 1 &&
                    currentElement.getPossibleSudokuElementValues().get(0) == tempElement.getCurrentSudokuElementValue()) {
                throw new BacktrackSudokuException("Backtrack Required");
            } else {
                removeExistingValueFromPossibleValues(tempElement, currentElement);
            }


        } else if (currentElement.getCurrentSudokuElementValue() == tempElement.getCurrentSudokuElementValue() && currentElement != tempElement) {
            throw new InvalidSudokuException("invalid Sudoku");

        }


    }


    public void removeExistingValueFromPossibleValues(SudokuElement tempElement, SudokuElement currentElement) {
        if (tempElement.getCurrentSudokuElementValue() != -1 && currentElement.getPossibleSudokuElementValues().contains(tempElement.getCurrentSudokuElementValue())) {
            currentElement.removeElementFromPossibleValuesByValue(tempElement.getCurrentSudokuElementValue());
            this.actionWasTaken = true;
        }
    }

    public void checkForLastElementInPossibleNumbers(int column, int row, SudokuElement currentElement) throws BacktrackSudokuException, InvalidSudokuException {
        if (currentElement.getPossibleSudokuElementValues().size() == 1 && currentElement.getCurrentSudokuElementValue() == -1) {
            rowChecker(row, currentElement);
            columnChecker(column, currentElement);
            squareChecker(column, row, currentElement);
            currentElement.setCurrentSudokuElementValue(currentElement.getPossibleSudokuElementValues().get(0));
            this.actionWasTaken = true;
        }
    }


    int rowAndColumnStartCalc(int value) {
        if (value < 3) {
            return 0;
        } else if (value < 6) {
            return 3;
        } else {
            return 6;
        }
    }


}

package com.kodilla.sudoku2;
import java.util.Scanner;

public class SudokuGame {

    public static int[] inputConverter(String input) {
        String[] inputArray = input.split(",");
        int[] outputArray = new int[inputArray.length];
        for (int i = 0; i < outputArray.length; i++) {
            outputArray[i] = Integer.parseInt(inputArray[i]);
        }
        return outputArray;
    }

    public static boolean inputValidator(String input,SudokuBoard board, SudokuSolver solver) throws InvalidSudokuException {
        if (input.toUpperCase().contains("SUDOKU")){
            solver.solveSudoku();
            System.out.println(solver.getGameBoard());
            return true;
        }
        if (input.matches("\\d"+","+"\\d"+","+"\\d")){
           boardSetterValidator(inputConverter(input),board);
            System.out.println(board);
            return false;
        }
        else {
            System.out.println("your input was wrong! Please try again");
            return false;
        }

    }

    public static void boardSetterValidator(int [] data, SudokuBoard board){
        if (data[0]<0 || data[0]>8 || data[1]<0 || data[1]>8){
            System.out.println("wrong coordinates");
        }
        else {
            board.setElement(data[0],data[1], data[2]);
        }
    }




    public static void main(String[] args) {
        String input;
        Scanner scanner = new Scanner(System.in);
        SudokuBoard board = new SudokuBoard();
        board.generateEmptyBoard();
        SudokuSolver solver=new SudokuSolver(board);
        boolean sudokuFinished;
        System.out.println(board);
        while (true) {
            input= scanner.nextLine();
            try {
               sudokuFinished=inputValidator(input,board,solver);
               if (sudokuFinished){
                   System.out.println("Sudoku was solved. Press Enter to continue or type anything to close program");
                   input=scanner.nextLine();
                   if (input.length()==0){
                       System.out.println("generating new empty board...");
                       board=new SudokuBoard();
                       board.generateEmptyBoard();
                       solver=new SudokuSolver(board);
                       System.out.println(board);
                   }else {
                       return;
                   }
               }
            } catch (InvalidSudokuException e) {
                System.out.println(e.getMessage());
                System.out.println("generating new empty board...");
                board=new SudokuBoard();
                board.generateEmptyBoard();
                solver=new SudokuSolver(board);
                System.out.println(board);
            }

        }
    }
}

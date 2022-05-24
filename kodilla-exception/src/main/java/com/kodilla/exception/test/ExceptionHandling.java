package com.kodilla.exception.test;

public class ExceptionHandling {
    public static void main(String[] args) {
        SecondChallenge secondChallenge=new SecondChallenge();
        String output;
        try{
            output=secondChallenge.probablyIWillThrowException(2,1);
            System.out.println(output);
        }catch (Exception e){
            System.out.println("Exception occurred: "+e);
        }finally {
            System.out.println("Program will now end. Have a nice day");
        }

    }
}

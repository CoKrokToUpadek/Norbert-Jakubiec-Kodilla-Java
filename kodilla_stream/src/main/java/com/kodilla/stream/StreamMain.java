package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.iterate.NumbersGenerator;
import com.kodilla.stream.lambda.ExecuteSaySomething;
import com.kodilla.stream.lambda.ExpressionExecutor;
import com.kodilla.stream.lambda.Processor;
import com.kodilla.stream.lambda.SaySomething;
import com.kodilla.stream.reference.FunctionalCalculator;

public class StreamMain {
    public static void main(String[] args) {
        System.out.println("Welcome to module 7 - Stream");


        System.out.println("Using Stream to generate even numbers from 1 to 20");
        NumbersGenerator.generateEven(20);


//        PoemBeautifier poemBeautifier=new PoemBeautifier();
//        poemBeautifier.beautify("Ala ma kota",((text)-> text.toUpperCase()));
//        poemBeautifier.beautify("Ala ma kota",((text)->"ABC "+text+" ABC"));
//        poemBeautifier.beautify("Ala ma kota",((text)->"|||| "+text+" ||||"));
//        poemBeautifier.beautify("Ala ma kota",((text)->"\u001B[31m"+text+"\u001B[0m"));
//        poemBeautifier.beautify("Ala ma kota",((text)-> {
//        String resetColorCommand="\u001b[0m";
//        String output="";
//            for(int i=0;i<text.length();i++){
//              output+="\u001B[3"+(i%7)+"m"+text.charAt(i);
//            }
//            return output+resetColorCommand;
//        }));


//        ExpressionExecutor expressionExecutor = new ExpressionExecutor();
//
//        System.out.println("Calculating expressions with lambdas");
//        expressionExecutor.executeExpression(10, 5, (a, b) -> a + b);
//        expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);
//        expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);
//        expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);
//
//        System.out.println("Calculating expressions with method references");
//        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::multiplyAByB);
//        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::addAToB);
//        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::subBFromA);
//        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::divideAByB);

//        Processor processor=new Processor();
//        ExecuteSaySomething executeSaySomething=new ExecuteSaySomething();
//        processor.execute(executeSaySomething);
//        processor.execute(() -> System.out.println("This is an example text."));
    }
}

package com.kodilla.stream;


import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;

import java.time.LocalDate;
import java.time.Period;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args) {


        //////////////////////////__7.3-forum user challenge__//////////////////////////////////////////////////
        Forum forum=new Forum();
        Map<Integer,ForumUser> par =forum.getForumUsers().stream().filter(s->s.getUserSex().equals(ForumUser.sex.M))
                .filter(s->{
                    return Period.between(s.getBirthdayDate(), LocalDate.now()).getYears() >= 20;
                }).filter(s->s.getNumberOfPosts()>0).collect(Collectors.toMap(ForumUser::getUserID,s->s));

        par.entrySet().stream().forEach(System.out::println);


        //////////////////////////__7.1-Poem Beautifier__//////////////////////////////////////////////////
        System.out.println("\n".repeat(2));

                PoemBeautifier poemBeautifier=new PoemBeautifier();
        poemBeautifier.beautify("Ala ma kota",((text)-> text.toUpperCase()));
        poemBeautifier.beautify("Ala ma kota",((text)->"ABC "+text+" ABC"));
        poemBeautifier.beautify("Ala ma kota",((text)->"|||| "+text+" ||||"));
        poemBeautifier.beautify("Ala ma kota",((text)->"\u001B[31m"+text+"\u001B[0m"));
        poemBeautifier.beautify("Ala ma kota",((text)-> {
        String resetColorCommand="\u001b[0m";
        String output="";
            for(int i=0;i<text.length();i++){
              output+="\u001B[3"+(i%7)+"m"+text.charAt(i);
            }
            return output+resetColorCommand;
        }));
    }
}

//
//            BookDirectory theBookDirectory = new BookDirectory();
//            String theResultStringOfBooks = theBookDirectory.getList().stream()
//                    .filter(book -> book.getYearOfPublication() > 2005)
//                    .map(Book::toString)
//                    .collect(Collectors.joining(",\n","<<",">>"));
//
//            System.out.println(theResultStringOfBooks);


//        BookDirectory theBookDirectory = new BookDirectory();
//        List<Book> theResultListOfBooks = theBookDirectory.getList().stream()
//                .filter(book -> book.getYearOfPublication() > 2005)
//                .collect(Collectors.toList());
//
//        System.out.println("# elements: " + theResultListOfBooks.size());
//        theResultListOfBooks.stream().forEach(System.out::println);



//        BookDirectory theBookDirectory = new BookDirectory();
//        theBookDirectory.getList().stream()
//                .filter(book -> book.getYearOfPublication() > 2005)
//                .forEach(System.out::println);



    ////////////////////////////---stream----////////////////////////////////////////

//        People.getList().stream().map(String::toUpperCase).filter(s->s.length()>11)
//        .map(s->{
//           String [] temp=s.split(" ");
//            return temp[0]+" "+temp[1].charAt(0)+".";
//        }).filter(s->s.charAt(0)=='M').forEach(System.out::println);



//        People.getList().stream().map(String::toUpperCase)
//        .filter(s->s.length()>11).forEach(System.out::println);



//        People.getList().stream().map(n->n.toUpperCase())
//        .forEach(System.out::println);

    ////////////////////////////////////////////////////////////////////////////////


//        System.out.println("Using Stream to generate even numbers from 1 to 20");
//        NumbersGenerator.generateEven(20);


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
//       processor.execute(() -> System.out.println("This is an example text."));

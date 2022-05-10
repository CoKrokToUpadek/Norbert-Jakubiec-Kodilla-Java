package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;
import com.kodilla.testing.user.SimpleUser;

public class TestingMain {
    public static void main(String[] args) {

        int a=8;
        int b=4;
        int addTest=a+b;
        int subtractTest=a-b;
        SimpleUser simpleUser=new SimpleUser("forumUser123");
        String result=simpleUser.getUsername();

        if (addTest==Calculator.add(a,b)){
            System.out.println("adding test passed");
        } else {
            System.out.println("adding test failed");
        }

        if (subtractTest==Calculator.subtract(a,b)){
            System.out.println("subtract test passed");
        } else {
            System.out.println("subtract test failed");
        }


        if (result.equals("forumUser123")){
            System.out.println("Test ok!");
        }else {
            System.out.println("Error!");
        }

    }
}

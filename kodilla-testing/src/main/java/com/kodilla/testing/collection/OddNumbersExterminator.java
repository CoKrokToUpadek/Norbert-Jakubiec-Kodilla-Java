package com.kodilla.testing.collection;

import java.util.ArrayList;
import java.util.List;

public class OddNumbersExterminator {

   static public List<Integer> exterminate(List<Integer> numbers){

       List<Integer> outputList=new ArrayList<>();
       //dunno if its needed
       if (numbers==null || numbers.isEmpty() || (numbers.size()==1 && numbers.get(0)%2==1)){
           return outputList;
       }

        for(Integer num:numbers){
            if (num%2==0){
                outputList.add(num);
            }
        }
        return outputList;
    }
}

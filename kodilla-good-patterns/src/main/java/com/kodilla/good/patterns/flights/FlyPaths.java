package com.kodilla.good.patterns.flights;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class FlyPaths {
    private final Airport airport;
    private final List<List<Airport>> thisIsStartingPoint;
    private final List<List<Airport>> thisIsEndPoint;
    private final List<List<Airport>> thisIsTransitPoint;



    public FlyPaths(Airport airportName) {
        this.airport = airportName;
        thisIsStartingPoint=new ArrayList<>();
        thisIsEndPoint=new ArrayList<>();
        thisIsTransitPoint=new ArrayList<>();
    }

    /*first airport is automatically set to be this key airport*/
    public void addNewFlyPathAsStartingPoint(Airport... airports){
        List<Airport> tempList=new ArrayList<>();
        if (airports.length==0){
            System.out.println("you cannot add empty fly path");
        }else {
            tempList.add(this.airport);
            tempList.addAll(Arrays.asList(airports));
            thisIsStartingPoint.add(tempList);
        }


    }
    /*last airport is automatically set to be this key airport*/
    public void addNewFlyPathAsEndPoint(Airport... airports){
        List<Airport> tempList=new ArrayList<>();
        if (airports.length==0){
            System.out.println("you cannot add empty fly path");
        }else {
            tempList.addAll(Arrays.asList(airports));
            tempList.add(this.airport);
            thisIsEndPoint.add(tempList);
        }
    }

    /*key airport must be in the argument list*/
    public void addNewFlyPathAsTransitPoint(Airport...airports){
        List<Airport> tempList=new ArrayList<>();
        if (Arrays.stream(airports).filter(e->e.equals(this.airport)).findFirst().orElse(null)==null){
            System.out.println("no key airport amidst argument list");
        }else{
            tempList.addAll(Arrays.asList(airports));
            thisIsTransitPoint.add(tempList);
        }
    }

    public void printStartPoints(int controller){

        switch (controller){
            case 1:
                System.out.println("fly paths where "+this.airport.getAirportName()+" is a start point");
                for (int i=0;i<thisIsStartingPoint.size();i++){
                    String output= thisIsStartingPoint.get(i).stream().map(Airport::getAirportName).collect(Collectors.joining("/"));
                    System.out.println(output);
                }
                System.out.println("-----------------------------------");
                break;
            case 2:
                System.out.println("fly paths where "+this.airport.getAirportName()+" is an end point");
                for (int i=0;i<thisIsEndPoint.size();i++){
                    String output= thisIsEndPoint.get(i).stream().map(Airport::getAirportName).collect(Collectors.joining("/"));
                    System.out.println(output);
                }
                System.out.println("-----------------------------------");
                break;
            case 3:
                System.out.println("fly paths where "+this.airport.getAirportName()+" is a transit point");
                for (int i=0;i<thisIsTransitPoint.size();i++){
                    String output= thisIsTransitPoint.get(i).stream().map(Airport::getAirportName).collect(Collectors.joining("/"));
                    System.out.println(output);
                }
                System.out.println("-----------------------------------");
                break;
            default:
                break;

        }

    }

}

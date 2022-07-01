package com.kodilla.good.patterns.flights;

import java.util.HashMap;
import java.util.Map;

public class FlyPathsDB {
    Map<Airport,FlyPaths> flyPathsMap;
    public FlyPathsDB() {
        flyPathsMap=new HashMap<>();
    }

    public void addAirportToDB(Airport key, FlyPaths value){
        flyPathsMap.put(key,value);
    }

    public void printPaths(Airport airport){
        FlyPaths temp=flyPathsMap.get(airport);
        for (int i=1;i<=3;i++){
            temp.printStartPoints(i);
        }

    }


}

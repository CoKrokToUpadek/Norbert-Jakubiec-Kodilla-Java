package com.kodilla.good.patterns.flights;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class FlyPathsDB {
    Map<Airport, FlyPaths> flyPathsMap;

    public FlyPathsDB() {
        flyPathsMap = new HashMap<>();
    }

    public void addAirportToDB(Airport key, FlyPaths value) {
        flyPathsMap.put(key, value);
    }

    public void printPaths(String airport) {
        Airport airport1;
        if (flyPathsMap.keySet().stream().anyMatch(flyPaths -> flyPaths.getAirportName().equals(airport))) {
            airport1 = flyPathsMap.keySet().stream().filter(flyPaths -> flyPaths.getAirportName().equals(airport)).findAny().get();
            FlyPaths temp = flyPathsMap.get(airport1);
            for (int i = 1; i <= 3; i++) {
                temp.printStartPoints(i);
            }
        } else {
            System.out.println("no airport found");
        }
    }


}

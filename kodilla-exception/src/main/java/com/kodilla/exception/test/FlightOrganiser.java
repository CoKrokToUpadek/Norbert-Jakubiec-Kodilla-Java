package com.kodilla.exception.test;

import com.kodilla.exception.nullpointer.MessageNotSentException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FlightOrganiser {

    public static void findFlight(Flight flight) throws RouteNotFoundException {

        Map<String, Boolean> flights=new HashMap<>();
        flights.put("Modlin",true);
        flights.put("Warszawa Okęcie",true);
        flights.put("Bydgoszcz",true);
        flights.put("Wrocław",true);
        flights.put("Wąchock",false);



        if(flights.containsKey(flight.getArrivalAirport())){
            System.out.println(flight.getArrivalAirport()+" was found.");
            if (flights.get(flight.getArrivalAirport())){
                System.out.println("Airport is available from your destination");
             }else {
               System.out.println("Airport is NOT available from your destination");
            }
        }else  {
            throw new RouteNotFoundException("Airport not found");
        }
    }

    public static void main(String[] args) {

        Flight flight=new Flight("Modlin","404");

        try{
            FlightOrganiser.findFlight(flight);
        }catch (RouteNotFoundException e){
            System.out.println("something went wrong:"+e.getMessage());
        }
    }
}

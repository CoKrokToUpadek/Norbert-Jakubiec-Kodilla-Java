package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class World {

    private final Set<Continent> continentsInTheWorld=new HashSet<>();

    public World() {
    }

    public void addContinent(Continent continent){
        continentsInTheWorld.add(continent);
    }

    public Set<Continent> getContinentsInTheWorld() {
        return new HashSet<>(continentsInTheWorld);
    }

    public BigDecimal getPeopleQuantity(){
        return  continentsInTheWorld.stream().flatMap(s->s.getCountriesInTheContinent().stream())
          .map(Country::getPeopleQuantity).reduce(BigDecimal.ZERO,(sum, current)->sum=sum.add(current));
    }

    public void print(){
        continentsInTheWorld.stream().map(Continent::getContinentName).forEach(System.out::println);
    }
}

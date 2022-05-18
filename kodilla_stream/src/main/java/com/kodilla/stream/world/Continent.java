package com.kodilla.stream.world;

import java.util.HashSet;
import java.util.Set;

public class Continent {

    private final String continentName;
     private final Set<Country> countriesInTheContinent=new HashSet<>();

    public Continent(String continentName) {
        this.continentName = continentName;
    }

    public void addCountry(Country country){
         countriesInTheContinent.add(country);
     }

    public Set<Country> getCountriesInTheContinent() {
        return new HashSet<>(countriesInTheContinent);
    }

    public String getContinentName() {
        return continentName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Continent continent = (Continent) o;

        return countriesInTheContinent.equals(continent.countriesInTheContinent);
    }

    @Override
    public int hashCode() {
        return countriesInTheContinent.hashCode();
    }
}

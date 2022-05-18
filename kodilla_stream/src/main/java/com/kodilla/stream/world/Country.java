package com.kodilla.stream.world;

import java.math.BigDecimal;

public class Country {

    private final String countryName;
    private final BigDecimal peopleCount;

    public Country(String countryName, BigDecimal peopleCount) {
        this.countryName = countryName;
        this.peopleCount = peopleCount;
    }

    public String getCountryName() {
        return countryName;
    }

    public BigDecimal getPeopleQuantity(){
        return peopleCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Country country = (Country) o;

        return countryName.equals(country.countryName);
    }

    @Override
    public int hashCode() {
        return countryName.hashCode();
    }
}

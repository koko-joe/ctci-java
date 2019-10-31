package chapter13;

import java.util.List;

/*
Chapter 13
Question 7

Given a list of countries, use lambda expression to get the population of a continent.
 */
public class ContinentPopulationCounter {

    int getPopulation(List<Country> countries, String continent) {
        return countries.stream()
                .filter(country -> country.getContinent().equals(continent))
                .mapToInt(Country::getPopulation)
                .sum();
    }
}

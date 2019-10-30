package chapter13;

import java.util.List;

public class ContinentPopulationCounter {

    int getPopulation(List<Country> countries, String continent) {
        return countries.stream()
                .filter(country -> country.getContinent().equals(continent))
                .mapToInt(Country::getPopulation)
                .sum();
    }
}

package chapter13;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

class ContinentPopulationCounterTest {

    private static ContinentPopulationCounter counter;
    private static final String CONTINENT = "Europe";
    private List<Country> countries;

    @BeforeAll
    static void setupBeforeAll() {
        counter = new ContinentPopulationCounter();
    }

    @BeforeEach
    void setupBeforeEach() {
        countries = new LinkedList<>();
    }

    @Test
    void testThatSumOfEmptyListIsZero() {
        String continent = "Europe";

        Assertions.assertEquals(0, counter.getPopulation(countries, continent));
    }

    @Test
    void testThatPopulationInContinentWithoutCountriesIsZero() {
        String continentWithoutCountries = "Shmurope";
        countries.add(new Country(CONTINENT, 1));

        Assertions.assertEquals(0, counter.getPopulation(countries, continentWithoutCountries));
    }

    @Test
    void testThatSingleCountryContinentHasSamePopulationAsCountry() {
        int population = 23;
        countries.add(new Country(CONTINENT, population));

        Assertions.assertEquals(population, counter.getPopulation(countries, CONTINENT));
    }

    @Test
    void testThatPopulationsOfTheSameContinentAreAdded() {
        int firstCountryPopulation = 1;
        int secondCountryPopulation = 2;
        countries.add(new Country(CONTINENT, firstCountryPopulation));
        countries.add(new Country(CONTINENT, secondCountryPopulation));

        Assertions.assertEquals(firstCountryPopulation + secondCountryPopulation, counter.getPopulation(countries, CONTINENT));
    }
}

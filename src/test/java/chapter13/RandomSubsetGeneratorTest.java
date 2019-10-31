package chapter13;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

class RandomSubsetGeneratorTest {

    private static RandomSubsetGenerator randomSubsetGenerator;

    @BeforeAll
    static void setup() {
        randomSubsetGenerator = new RandomSubsetGenerator();
    }

    @Test
    void testThatEmptySubsetIsGenerated() {
        List<Integer> set = new LinkedList<>();
        set.add(1);
        set.add(2);
        set.add(3);
        Random randomGenerator = Mockito.mock(Random.class);
        Mockito.when(randomGenerator.nextBoolean()).thenReturn(false);
        List<Integer> subset = randomSubsetGenerator.generateRandomSubset(set, randomGenerator);

        Assertions.assertEquals(0, subset.size());
    }

    @Test
    void testThatFullSubsetIsGenerated() {
        List<Integer> set = new LinkedList<>();
        set.add(1);
        set.add(2);
        set.add(3);
        Random randomGenerator = Mockito.mock(Random.class);
        Mockito.when(randomGenerator.nextBoolean()).thenReturn(true);
        List<Integer> subset = randomSubsetGenerator.generateRandomSubset(set, randomGenerator);

        Assertions.assertEquals(set, subset);
    }

    @Test
    void testThatRandomSubsetIsGenerated() {
        List<Integer> set = new LinkedList<>();
        set.add(1);
        set.add(2);
        set.add(3);
        Random randomGenerator = new Random();
        List<Integer> subset = randomSubsetGenerator.generateRandomSubset(set, randomGenerator);

        for (Integer item:subset) {
            Assertions.assertTrue(set.contains(item));
        }
    }
}

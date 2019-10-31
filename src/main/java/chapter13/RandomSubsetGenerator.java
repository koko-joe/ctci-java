package chapter13;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/*
Chapter 13
Question 8

Return a random subset of a given list
 */
public class RandomSubsetGenerator {

    List<Integer> generateRandomSubset(List<Integer> set, Random randomGenerator) {
        return set.stream()
                .filter(item -> randomGenerator.nextBoolean())
                .collect(Collectors.toList());
    }
}

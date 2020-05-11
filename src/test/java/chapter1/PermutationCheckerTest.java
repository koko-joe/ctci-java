package chapter1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class PermutationCheckerTest {

    private static PermutationChecker permutationChecker;

    @BeforeAll
    static void setUp() {
        permutationChecker = new PermutationChecker();
    }

    @Test
    void testThatEmptyStringIsPermutationOfEmptyString() {
        boolean arePermutations = permutationChecker.arePermutations("", "");
        Assertions.assertTrue(arePermutations);
    }

    @Test
    void testThatEmptyStringIsNotPermutationOfNonEmptyString() {
        String string = "test";
        boolean arePermutations = permutationChecker.arePermutations(string, "");
        Assertions.assertFalse(arePermutations);
    }

    @Test
    void testThatStringsOfDifferentLengthAreNotPermutations() {
        String firstString = "dog";
        String secondString = "doge";
        boolean arePermutations = permutationChecker.arePermutations(firstString, secondString);
        Assertions.assertFalse(arePermutations);
    }

    @Test
    void testThatDifferentStringsWithSameLengthAreNotPermutations() {
        String firstString = "dog";
        String secondString = "cat";
        boolean arePermutations = permutationChecker.arePermutations(firstString, secondString);
        Assertions.assertFalse(arePermutations);
    }

    @Test
    void testNonEmptyPermutationIsDetected() {
        String firstString = "dog";
        String secondString = "god";
        boolean arePermutations = permutationChecker.arePermutations(firstString, secondString);
        Assertions.assertTrue(arePermutations);
    }
}

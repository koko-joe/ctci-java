package chapter1;

import java.util.Arrays;

/*
Chapter 1
Question 2

Tests if 2 strings are permutations of each other.
 */
public class PermutationChecker {

    /**
     * Returns true if the 2 given strings are permutations of each other.
     * This check is CASE SENSITIVE.
     * An exception is thrown if any of the arguments is NULL.
     */
    public boolean arePermutations(String firstString, String secondString) throws IllegalArgumentException {
        if (firstString == null) {
            throw new IllegalArgumentException();
        }

        if (secondString == null) {
            throw new IllegalArgumentException();
        }

        if (firstString.length() != secondString.length()) {
            return false;
        }

        char[] firstStringCharacters = firstString.toCharArray();
        char[] secondStringCharacters = secondString.toCharArray();

        Arrays.sort(firstStringCharacters);
        Arrays.sort(secondStringCharacters);

        return Arrays.equals(firstStringCharacters, secondStringCharacters);
    }
}

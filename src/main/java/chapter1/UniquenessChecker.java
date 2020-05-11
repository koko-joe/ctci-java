package chapter1;

/*
Chapter 1
Question 1

Tests if a string contains only unique characters.
Assumptions: only ASCII characters are used, lowercase and uppercase characters are not the same
 */
public class UniquenessChecker {

    public boolean hasOnlyUniqueCharacters(String inputString) {
        final int characterRange = 256;
        boolean[] characterIsFound = new boolean[characterRange];

        if (inputString.length() > characterRange) {
            return false;
        }

        for (int i = 0; i < inputString.length(); ++i) {
            int currentCharacter = inputString.charAt(i);
            if (characterIsFound[currentCharacter]) {
                return false;
            }
            characterIsFound[currentCharacter] = true;
        }
        return true;
    }
}

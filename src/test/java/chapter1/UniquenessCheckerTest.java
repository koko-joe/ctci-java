package chapter1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class UniquenessCheckerTest {

    private static UniquenessChecker isUniqueChecker;

    @BeforeAll
    static void setup() {
        isUniqueChecker = new UniquenessChecker();
    }

    @Test
    void testThatEmptyStringIsUnique() {
        Assertions.assertTrue(isUniqueChecker.hasOnlyUniqueCharacters(""));
    }

    @ParameterizedTest
    @ValueSource(strings={"a", "abc", "qwertz", "Aa", "öÖ", "AB", " "})
    void testUniqueString(String word) {
        Assertions.assertTrue(isUniqueChecker.hasOnlyUniqueCharacters(word));
    }

    @ParameterizedTest
    @ValueSource(strings={"aa", "abcb", "qweertz", "AA", "öö", "ABA", "  "})
    void testNonUniqueString(String word) {
        Assertions.assertFalse(isUniqueChecker.hasOnlyUniqueCharacters(word));
    }
}

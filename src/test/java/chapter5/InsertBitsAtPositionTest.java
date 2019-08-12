package chapter5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class InsertBitsAtPositionTest {

    private static BitMerger bitMerger;

    @BeforeAll
    static void setUp() {
        bitMerger = new BitMerger();
    }

    @Test
    void testFullInsertion() {
        final int source = 1317;
        final int target = 4371;

        int result = bitMerger.insertBitsAtPosition(source, target, 0, Integer.SIZE - 1);
        Assertions.assertEquals(source, result);
    }

    @Test
    void testBookExample() {
        final int source = 19;
        final int target = 1024;

        final int startPosition = 2;
        int result = bitMerger.insertBitsAtPosition(source, target, startPosition, 6);
        Assertions.assertEquals(1024 + (19 * Math.pow(2, startPosition)), result);
    }
}

package chapter8;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class TripleHopTest {

    private static TripleHop tripleHop;

    @BeforeAll
    static void setup() {
        tripleHop = new TripleHop();
    }

    @Test
    void testZeroSteps() {
        int steps = tripleHop.calculateHops(0);
        Assertions.assertEquals(0, steps);
    }

    @Test
    void testOneStep() {
        int steps = tripleHop.calculateHops(1);
        Assertions.assertEquals(1, steps);
    }

    @Test
    void testTwoSteps() {
        int steps = tripleHop.calculateHops(2);
        Assertions.assertEquals(2, steps);
    }

    @Test
    void testThreeSteps() {
        int steps = tripleHop.calculateHops(3);
        Assertions.assertEquals(4, steps);
    }

    @Test
    void testFourSteps() {
        int steps = tripleHop.calculateHops(4);
        Assertions.assertEquals(7, steps);
    }

    @Test
    void testTenSteps() {
        int steps = tripleHop.calculateHops(10);
        Assertions.assertEquals(274, steps);
    }

    @Test
    void testThirtySteps() {
        int steps = tripleHop.calculateHops(30);
        Assertions.assertEquals(53798080, steps);
    }
}

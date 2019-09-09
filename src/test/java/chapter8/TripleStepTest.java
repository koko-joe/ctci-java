package chapter8;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class TripleStepTest {

    private static TripleStep tripleStep;

    @BeforeAll
    static void setup() {
        tripleStep = new TripleStep();
    }

    @Test
    void testZeroSteps() {
        int steps = tripleStep.countPossibleWays(0);
        Assertions.assertEquals(0, steps);
    }

    @Test
    void testOneStep() {
        int steps = tripleStep.countPossibleWays(1);
        Assertions.assertEquals(1, steps);
    }

    @Test
    void testTwoSteps() {
        int steps = tripleStep.countPossibleWays(2);
        Assertions.assertEquals(2, steps);
    }

    @Test
    void testThreeSteps() {
        int steps = tripleStep.countPossibleWays(3);
        Assertions.assertEquals(4, steps);
    }

    @Test
    void testFourSteps() {
        int steps = tripleStep.countPossibleWays(4);
        Assertions.assertEquals(7, steps);
    }

    @Test
    void testTenSteps() {
        int steps = tripleStep.countPossibleWays(10);
        Assertions.assertEquals(274, steps);
    }

    @Test
    void testThirtySteps() {
        int steps = tripleStep.countPossibleWays(30);
        Assertions.assertEquals(53798080, steps);
    }
}

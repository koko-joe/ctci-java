package chapter8;

/*
Chapter 8
Question 1

There are n steps (e.g. on a stair) and you can take 1, 2 or 3 steps (hops) at once.
How many possible ways are there to take the stairs?
Assumptions:
- 0 (or negative) steps have 0 possibilities
 */
public class TripleHop {

    public int calculateHops(final int steps) {
        final int HOPS_FOR_ZERO_STEPS = 0;
        if (steps < 1) {
            return HOPS_FOR_ZERO_STEPS;
        }

        final int HOPS_FOR_ONE_STEP = 1;
        if (steps == 1) {
            return HOPS_FOR_ONE_STEP;
        }

        final int HOPS_FOR_TWO_STEPS = 2;
        if (steps == 2) {
            return HOPS_FOR_TWO_STEPS;
        }

        final int HOPS_FOR_THREE_STEPS = 4;
        if (steps == 3) {
            return HOPS_FOR_THREE_STEPS;
        }

        // You got 3 possibilities for the first step:
        // either you take 1 step (same possibility space as f(n-1))
        // or 2 steps at once (f(n-2))
        // or 3 steps at once (f(n-3))
        // f(n) = f(n-1) + f(n-2) + f(n-3)
        int hopsForNMinusTwoSteps = HOPS_FOR_ONE_STEP;
        int hopsForNMinusOneSteps = HOPS_FOR_TWO_STEPS;
        int hopsForNSteps = HOPS_FOR_THREE_STEPS;
        int tempHops;

        for (int i = 4; i <= steps; ++i) {
            tempHops = hopsForNSteps;
            hopsForNSteps = hopsForNSteps + hopsForNMinusOneSteps + hopsForNMinusTwoSteps;
            hopsForNMinusTwoSteps = hopsForNMinusOneSteps;
            hopsForNMinusOneSteps = tempHops;
        }

        return hopsForNSteps;
    }
}

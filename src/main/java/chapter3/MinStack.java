package chapter3;

import java.util.EmptyStackException;
import java.util.Stack;

/*
Chapter 3
Question 2

A stack with the operation push, pop and min.
The min-method returns the minimum element in the stack.
Push, pop and min have O(1) time complexity.
 */
public class MinStack {

    private final Stack<Integer> values;

    private final Stack<Integer> minValues;

    public MinStack() {
        values = new Stack<>();
        minValues = new Stack<>();
    }

    public Integer pop() throws EmptyStackException {
        if (values.empty()) {
            throw new EmptyStackException();
        }

        final Integer value = values.pop();

        // if popped value is minimum -> remove it from minimums
        if (min().equals(value)) {
            minValues.pop();
        }
        return value;
    }

    public void push(Integer value) {
        /*
         New value could be a new minimum.
         It can be equal to the last minimum in this case we need it twice on the min stack.
         If we would only have the min value once, we would have to search if it exists
         at another position in the value stack.
         If the stack was empty before, the new element is automatically the minimum.
         */
        if (minValues.empty() || (value <= min())) {
            minValues.push(value);
        }

        values.push(value);
    }

    public Integer min() {
        if (minValues.empty()) {
            throw new EmptyStackException();
        }

        return minValues.peek();
    }
}

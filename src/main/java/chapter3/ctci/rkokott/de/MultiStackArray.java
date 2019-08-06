package chapter3.ctci.rkokott.de;

import java.util.EmptyStackException;

/*
Chapter 3
Question 1

3 stacks within a single array
Assumptions:
- every stack has the same max size
- the max size can't change after initialization
- it's very likely someone wants 4 or 5 ... stacks in the future
- number of stacks can't change after initialization
 */
public class MultiStackArray {

    private final int stackCount;

    private final int maxStackSize;

    private int[] stack;

    private int[] stackSizes;

    public MultiStackArray(int stackCount, int maxStackSize) {
        this.stackCount = stackCount;
        this.maxStackSize = maxStackSize;
        this.stack = new int[stackCount * maxStackSize];
        this.stackSizes = new int[stackCount];
    }

    public void push(int stackNumber, int value) throws FullStackException, IllegalStackNumberException {
        evaluateStackNumber(stackNumber);

        if (isFull(stackNumber)) {
            throw new FullStackException();
        }

        int positionToInsert = getNextFreePosition(stackNumber);
        stack[positionToInsert] = value;

        ++stackSizes[stackNumber];
    }

    private int getNextFreePosition(int stackNumber) {
        return stackNumber * maxStackSize + stackSizes[stackNumber];
    }

    private void evaluateStackNumber(int stackNumber) throws IllegalStackNumberException {
        if (stackNumber >= stackCount || stackNumber < 0) {
            throw new IllegalStackNumberException(stackNumber);
        }
    }

    public int pop(int stackNumber) throws IllegalStackNumberException, EmptyStackException {
        evaluateStackNumber(stackNumber);

        if (isEmpty(stackNumber)) {
            throw new EmptyStackException();
        }

        int currentStackPosition = getNextFreePosition(stackNumber) - 1;
        int value = stack[currentStackPosition];
        stack[currentStackPosition] = 0;
        --stackSizes[stackNumber];

        return value;
    }

    public int peek(int stackNumber) throws IllegalStackNumberException {
        evaluateStackNumber(stackNumber);

        if (isEmpty(stackNumber)) {
            throw new EmptyStackException();
        }

        int currentStackPosition = getNextFreePosition(stackNumber) - 1;
        return stack[currentStackPosition];
    }

    public boolean isEmpty(int stackNumber) throws IllegalStackNumberException {
        evaluateStackNumber(stackNumber);

        return stackSizes[stackNumber] == 0;
    }

    public boolean isFull(int stackNumber) throws IllegalStackNumberException {
        evaluateStackNumber(stackNumber);

        return stackSizes[stackNumber] == maxStackSize;
    }
}

package chapter3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MinStackTest {

    private MinStack minStack;

    @BeforeEach
    void setup() {
        minStack = new MinStack();
    }

    @Test
    void testThatDecreasingStackReturnsTopElement() {
        int[] elements = {5,4,3,2,1};
        for (int element : elements) {
            minStack.push(element);
        }

        for (int position = (elements.length - 1); position >= 0; --position) {
            Assertions.assertEquals(elements[position], minStack.min());
            minStack.pop();
        }
    }

    @Test
    void testThatIncreasingStackReturnsBottomElement() {
        int[] elements = {1,2,3,4,5};
        for (int element : elements) {
            minStack.push(element);
        }

        for (int element : elements) {
            Assertions.assertEquals(elements[0], minStack.min());
            minStack.pop();
        }
    }

    @Test
    void testThatArbitraryStackMinima() {
        int[] elements = {7,5,99};
        for (int element : elements) {
            minStack.push(element);
        }

        int currentMin = Math.min(elements[2], Math.min(elements[1], elements[0]));
        Assertions.assertEquals(currentMin, minStack.min());

        minStack.pop();
        currentMin = Math.min(elements[1], elements[0]);
        Assertions.assertEquals(currentMin, minStack.min());

        minStack.pop();
        currentMin = elements[0];
        Assertions.assertEquals(currentMin, minStack.min());
    }

    @Test
    void testThatNonUniqueMinima() {
        int[] elements = {7,5,5};
        for (int element : elements) {
            minStack.push(element);
        }

        int currentMin = Math.min(elements[2], Math.min(elements[1], elements[0]));
        Assertions.assertEquals(currentMin, minStack.min());

        minStack.pop();
        currentMin = Math.min(elements[1], elements[0]);
        Assertions.assertEquals(currentMin, minStack.min());

        minStack.pop();
        currentMin = elements[0];
        Assertions.assertEquals(currentMin, minStack.min());
    }
}

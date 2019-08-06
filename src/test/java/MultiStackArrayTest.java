import chapter3.ctci.rkokott.de.FullStackException;
import chapter3.ctci.rkokott.de.IllegalStackNumberException;
import chapter3.ctci.rkokott.de.MultiStackArray;
import org.junit.jupiter.api.*;

class MultiStackArrayTest {

    private MultiStackArray stack;

    private static final int stackCount = 3;

    private static final int stackSize = 2;

    @BeforeEach
    void setup() {
        stack = new MultiStackArray(stackCount, stackSize);
    }

    @Test
    void testThatInitialStacksAreEmpty() throws IllegalStackNumberException {
        for (int i = 0; i < stackCount; ++i) {
            Assertions.assertTrue(stack.isEmpty(i));
        }
    }

    @Test
    void testThatPushInsertsIntoGivenStack() throws FullStackException, IllegalStackNumberException {
        final int stackNumber = 0;
        final int value = 11;
        stack.push(stackNumber, value);

        Assertions.assertFalse(stack.isEmpty(stackNumber));
    }

    @Test
    void testThatPushIgnoresOtherStacks() throws FullStackException, IllegalStackNumberException {
        final int stackNumber = 1;
        final int value = 22;
        stack.push(stackNumber, value);

        for (int i = 0; i < stackCount; ++i) {
            if (i == stackNumber) {
                continue;
            }
            Assertions.assertTrue(stack.isEmpty(i));
        }
    }

    @Test
    void testThatPeekReturnsPushedValue() throws IllegalStackNumberException, FullStackException {
        final int stackNumber = 2;
        final int value = 33;
        stack.push(stackNumber, value);

        Assertions.assertEquals(value, stack.peek(stackNumber));
    }

    @Test
    void testThatFullStackIsFull() throws FullStackException, IllegalStackNumberException {
        final int stackNumber = 0;
        final int firstValue = 44;
        final int secondValue = 55;
        stack.push(stackNumber, firstValue);
        stack.push(stackNumber, secondValue);

        Assertions.assertTrue(stack.isFull(stackNumber));
    }

    @Test
    void testThatEmptyStacksAreNotFull() throws IllegalStackNumberException, FullStackException {
        final int stackNumber = 1;
        final int firstValue = 66;
        final int secondValue = 77;
        stack.push(stackNumber, firstValue);
        stack.push(stackNumber, secondValue);

        for (int i = 0; i < stackCount; ++i) {
            if (i == stackNumber) {
                continue;
            }
            Assertions.assertFalse(stack.isFull(i));
        }
    }

    @Test
    void testThatPopReturnsPushedValue() throws IllegalStackNumberException, FullStackException {
        final int stackNumber = 2;
        final int firstValue = 88;
        final int secondValue = 99;
        stack.push(stackNumber, firstValue);
        stack.push(stackNumber, secondValue);
        final int poppedValue = stack.pop(stackNumber);

        Assertions.assertEquals(secondValue, poppedValue);
    }
}

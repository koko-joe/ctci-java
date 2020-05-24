package chapter2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;

public class KthLastElementListTest {

    private static KthLastElementList kthLastElementList;

    @BeforeAll
    static void setup() {
        kthLastElementList = new KthLastElementList();
    }

    @Test
    void testThatLastElementIsReturned() {
        Integer[] originalIntegers = {1,2,3,4,5,6,7,8,9,10};
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(originalIntegers));

        Integer lastElement = kthLastElementList.getKthLastElement(list, 0);
        Assertions.assertEquals(
            originalIntegers[originalIntegers.length - 1].intValue(),
            lastElement.intValue()
        );
    }

    @Test
    void testThatFirstElementIsReturned() {
        Integer[] originalIntegers = {1,2,3,4,5,6,7,8,9,10};
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(originalIntegers));

        Integer lastElement = kthLastElementList.getKthLastElement(list, originalIntegers.length - 1);
        Assertions.assertEquals(
                originalIntegers[0].intValue(),
                lastElement.intValue()
        );
    }

    @Test
    void testThatElementInBetweenIsReturned() {
        Integer[] originalIntegers = {1,2,3,4,5,6,7,8,9,10};
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(originalIntegers));

        Integer middleElement = kthLastElementList.getKthLastElement(list, 7);
        Assertions.assertEquals(
                originalIntegers[2].intValue(),
                middleElement.intValue()
        );
    }
}

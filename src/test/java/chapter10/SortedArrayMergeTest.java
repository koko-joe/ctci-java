package chapter10;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class SortedArrayMergeTest {

    private static SortedArrayMerge sortedArrayMerge;

    @BeforeAll
    static void setup() {
        sortedArrayMerge = new SortedArrayMerge();
    }

    @Test
    void testThatEmptyArraysAreMergedIntoEmptyArray() {
        int[] firstArray = {};
        int[] secondArray = {};

        sortedArrayMerge.mergeSortedArrays(firstArray, 0, secondArray, 0);
        Assertions.assertEquals(0, firstArray.length);
    }

    @Test
    void testThatMergingWithEmptySecondArrayIsTheSameAsFirstArray() {
        int[] firstArray = {1,2,3};
        int[] firstArrayCopy = {0,0,0};
        System.arraycopy(firstArray, 0, firstArrayCopy, 0, firstArray.length);
        int[] secondArray = {};

        sortedArrayMerge.mergeSortedArrays(firstArray, 3, secondArray, 0);
        Assertions.assertArrayEquals(firstArrayCopy, firstArray);
    }

    @Test
    void testThatMergingWithEmptyFirstArrayIsTheSameAsSecondArray() {
        int[] firstArray = {0,0,0};
        int[] secondArray = {0,1,2};

        sortedArrayMerge.mergeSortedArrays(firstArray, 0, secondArray, 3);
        Assertions.assertArrayEquals(secondArray, firstArray);
    }

    @Test
    void testThatNonEmptyArraysAreMergedInOrder() {
        int[] firstArray = {1,3,5,7,8,0,0,0,0,0};
        int[] secondArray = {2,4,6,9,10};
        int[] expectedResult = {1,2,3,4,5,6,7,8,9,10};

        sortedArrayMerge.mergeSortedArrays(firstArray, 5, secondArray, 5);
        Assertions.assertArrayEquals(expectedResult, firstArray);
    }
}

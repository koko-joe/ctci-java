package chapter10;

/*
Chapter 10
Question 1

Given 2 sorted arrays, merge the second array into the first in sorted order.
Assumptions: - both arrays are sorted in ascend order
- the resulting array is also in ascending order
- they are int arrays
- the first array has always enough free space to also store all values from second array
 */
public class SortedArrayMerge {

    /**
     * @param firstSortedArray is mutated!
     * @param firstArraySize element count of first array, there should be enough space left to fit the second array in it, elements with a bigger index are overwritten and not considered to be sorted
     * @param secondSortedArray the second sorted array
     * @param secondArraySize element count of second array
     */
    public void mergeSortedArrays(int[] firstSortedArray, int firstArraySize, int[] secondSortedArray, int secondArraySize) {
        int firstArrayPosition = firstArraySize - 1;
        int secondArrayPosition = secondArraySize - 1;

        for (int mergePosition = firstArraySize + secondArraySize - 1; mergePosition >= 0; --mergePosition) {
            if (firstArrayPosition < 0) {
                firstSortedArray[mergePosition] = secondSortedArray[secondArrayPosition];
                --secondArrayPosition;
                continue;
            }

            if (secondArrayPosition < 0) {
                firstSortedArray[mergePosition] = firstSortedArray[firstArrayPosition];
                --firstArrayPosition;
                continue;
            }

            if (firstSortedArray[firstArrayPosition] > secondSortedArray[secondArrayPosition]) {
                firstSortedArray[mergePosition] = firstSortedArray[firstArrayPosition];
                --firstArrayPosition;
            } else {
                firstSortedArray[mergePosition] = secondSortedArray[secondArrayPosition];
                --secondArrayPosition;
            }
        }
    }
}

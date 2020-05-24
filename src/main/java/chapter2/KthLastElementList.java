package chapter2;

import java.util.LinkedList;

/*
Chapter 2
Question 2

Return the kth to last element from a linked list.
 */
public class KthLastElementList {

    /**
     * k can be between 0 (last element) and list size - 1 (first element).
     * If k is below 0 or above list size - 1 an error is thrown.
     */
    public Integer getKthLastElement(LinkedList<Integer> list, int k) throws IndexOutOfBoundsException {
        if (k < 0) {
            throw new IndexOutOfBoundsException();
        }

        if (k >= list.size()) {
            throw new IndexOutOfBoundsException();
        }

        return list.get(list.size() - 1 - k);
    }
}

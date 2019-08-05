package chapter2.ctci.rkokott.de;

import java.util.LinkedList;
import java.util.ListIterator;

/*
Chapter 2
Question 1

Remove duplicates from an unordered linked list.
 */
public class LinkedListDuplicateRemover {

    public void removeDuplicates(LinkedList<Integer> list) {
        if (list.size() < 2) {
            return;
        }

        int currentIndex = 0;
        ListIterator<Integer> iterator = list.listIterator();

        while (iterator.hasNext()) {
            Integer originalValue = iterator.next();
            while (iterator.hasNext()) {
                Integer currentValue = iterator.next();
                if (originalValue.equals(currentValue)) {
                    iterator.remove();
                }
            }
            ++currentIndex;
            iterator = list.listIterator(currentIndex);
        }

    }
}

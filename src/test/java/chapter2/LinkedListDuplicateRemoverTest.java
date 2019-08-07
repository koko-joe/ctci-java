package chapter2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

class LinkedListDuplicateRemoverTest {

    private static LinkedListDuplicateRemover remover;

    @BeforeAll
    static void setup() {
        remover = new LinkedListDuplicateRemover();
    }

    @Test
    void testEmptyList() {
        LinkedList<Integer> emptyList = new LinkedList<Integer>();
        remover.removeDuplicates(emptyList);
        Assertions.assertEquals(emptyList.size(), 0);
    }

    @Test
    void testListWithoutDuplicate() {
        Integer[] originalIntegers = {1,2,3,4,5,6,7,8,9,10};
        LinkedList<Integer> list = new LinkedList<Integer>(Arrays.asList(originalIntegers));
        remover.removeDuplicates(list);
        Assertions.assertEquals(list.size(), originalIntegers.length);
        for (Integer value : originalIntegers) {
            Assertions.assertTrue(list.contains(value));
        }
    }

    @Test
    void testListWithDuplicates() {
        Integer[] originalIntegers = {1,2,1,3,4,5,3,6,7,8,9,10};
        Set<Integer> integerSet = new HashSet<Integer>(Arrays.asList(originalIntegers));
        LinkedList<Integer> list = new LinkedList<Integer>(Arrays.asList(originalIntegers));
        remover.removeDuplicates(list);
        Assertions.assertEquals(list.size(), integerSet.size());
        for (Integer value : integerSet) {
            Assertions.assertTrue(list.contains(value));
        }
    }
}

package chapter16;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Optional;

/*
Chapter 16
Question 25

LRU cache
 */
public class LeastRecentlyUsedCache<Key, Value> {

    private Deque<Key> keyList;

    private HashMap<Key, Value> values;

    private int size;

    public LeastRecentlyUsedCache(int size) {
        this.size = size;
        keyList = new LinkedList<>();
        values = new HashMap<>(size);
    }

    public Optional<Value> getValueByKey(Key key) {
        if (! values.containsKey(key)) {
            return Optional.empty();
        }
        keyList.remove(key);
        keyList.addFirst(key);
        return Optional.ofNullable(values.get(key));
    }

    private void removeLeastRecentlyUsedValue() {
        Key oldestKey = keyList.removeLast();
        values.remove(oldestKey);
    }

    public void insertValue(Key key, Value value) {
        if (values.size() >= size) {
            removeLeastRecentlyUsedValue();
        }

        keyList.addFirst(key);
        values.put(key, value);
    }
}

package chapter16;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

class LeastRecentlyUsedCacheTest {

    private LeastRecentlyUsedCache<Integer, String> lruCache;

    private final int cacheSize = 3;

    @BeforeEach
    void setup() {
        lruCache = new LeastRecentlyUsedCache<>(cacheSize);
    }

    @Test
    void testThatEmptyCacheReturnsNull() {
        Optional<String> result = lruCache.getValueByKey(1);
        Assertions.assertFalse(result.isPresent());
    }

    @Test
    void testThatExistingValueIsReturned() {
        Integer key = 11;
        String value = "existing";
        lruCache.insertValue(key, value);
        Optional<String> result = lruCache.getValueByKey(key);

        Assertions.assertEquals(value, result.orElse(value + "different"));
    }

    @Test
    void testThatNonEmptyCacheReturnsNullIfKeyIsNotFound() {
        for (int i = 0; i < cacheSize; ++i) {
            lruCache.insertValue(i, String.valueOf(i));
        }
        Optional<String> result = lruCache.getValueByKey(cacheSize);
        Assertions.assertFalse(result.isPresent());
    }

    @Test
    void testThatLeastRecentlyUsedItemIsRemoved() {
        for (int i = 0; i <= cacheSize; ++i) {
            lruCache.insertValue(i, String.valueOf(i));
        }
        Optional<String> result = lruCache.getValueByKey(0);
        Assertions.assertFalse(result.isPresent());
    }

    @Test
    void testThatNewItemIsAddedIfCacheIsAlreadyFull() {
        for (int i = 0; i <= cacheSize; ++i) {
            lruCache.insertValue(i, String.valueOf(i));
        }
        Optional<String> result = lruCache.getValueByKey(cacheSize);
        Assertions.assertEquals(String.valueOf(cacheSize), result.orElse("0"));
    }
}

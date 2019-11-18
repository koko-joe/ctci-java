package chapter16;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LeastRecentlyUsedCacheTest {

    private LeastRecentlyUsedCache<Integer, String> lruCache;

    private final int cacheSize = 3;

    @BeforeEach
    void setup() {
        lruCache = new LeastRecentlyUsedCache<>(cacheSize);
    }

    @Test
    void testThatEmptyCacheReturnsNull() {
        String result = lruCache.getValueByKey(1);
        Assertions.assertNull(result);
    }

    @Test
    void testThatExistingValueIsReturned() {
        Integer key = 11;
        String value = "existing";
        lruCache.insertValue(key, value);
        String result = lruCache.getValueByKey(key);

        Assertions.assertEquals(value, result);
    }

    @Test
    void testThatNonEmptyCacheReturnsNullIfKeyIsNotFound() {
        for (int i = 0; i < cacheSize; ++i) {
            lruCache.insertValue(i, String.valueOf(i));
        }
        String result = lruCache.getValueByKey(cacheSize);
        Assertions.assertNull(result);
    }

    @Test
    void testThatLeastRecentlyUsedItemIsRemoved() {
        for (int i = 0; i <= cacheSize; ++i) {
            lruCache.insertValue(i, String.valueOf(i));
        }
        String result = lruCache.getValueByKey(0);
        Assertions.assertNull(result);
    }

    @Test
    void testThatNewItemIsAddedIfCacheIsAlreadyFull() {
        for (int i = 0; i <= cacheSize; ++i) {
            lruCache.insertValue(i, String.valueOf(i));
        }
        String result = lruCache.getValueByKey(cacheSize);
        Assertions.assertEquals(String.valueOf(cacheSize), result);
    }
}

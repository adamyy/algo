package cache;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class LRUCacheTest {

  @Test
  public void getAndPut() {
    LRUCache<Integer, Integer> cache = new LRUCache<>(2);
    cache.put(1, 1);
    cache.put(2, 2);
    assertThat(cache.get(1)).isEqualTo(1);
    cache.put(3, 3);    // evicts key 2
    assertThat(cache.get(2)).isNull(); // not found
    cache.put(4, 4);    // evicts key 1
    assertThat(cache.get(1)).isNull(); // not found
    assertThat(cache.get(3)).isEqualTo(3);
    assertThat(cache.get(4)).isEqualTo(4);
  }
}
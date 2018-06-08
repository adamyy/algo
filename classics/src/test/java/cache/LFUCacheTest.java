package cache;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class LFUCacheTest {

  @Test
  public void testEviction() {
    LFUCache<Integer, Integer> cache = new LFUCache<>(2);

    cache.put(1, 1);
    cache.put(2, 2);
    assertThat(cache.get(1)).isEqualTo(1);
    cache.put(3, 3);    // evicts key 2
    assertThat(cache.get(2)).isEqualTo(null); // not found
    assertThat(cache.get(3)).isEqualTo(3);
    cache.put(4, 4);    // evicts key 1.
    assertThat(cache.get(1)).isEqualTo(null); // not found
    assertThat(cache.get(3)).isEqualTo(3);
    assertThat(cache.get(4)).isEqualTo(4);
  }

  @Test
  public void testRecentlyUsed() {
    LFUCache<Integer, Integer> cache = new LFUCache<>(3);

    cache.put(2, 2);
    cache.put(1, 1);
    assertThat(cache.get(2)).isEqualTo(2);
    assertThat(cache.get(1)).isEqualTo(1);
    assertThat(cache.get(2)).isEqualTo(2);
    cache.put(3, 3);
    cache.put(4, 4); // evict 3
    assertThat(cache.get(3)).isEqualTo(null);
    assertThat(cache.get(2)).isEqualTo(2);
    assertThat(cache.get(1)).isEqualTo(1);
    assertThat(cache.get(4)).isEqualTo(4);
  }
}
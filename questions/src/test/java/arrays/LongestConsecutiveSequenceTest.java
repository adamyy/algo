package arrays;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class LongestConsecutiveSequenceTest {

  @Test
  public void longestConsecutiveHashMap() {
    assertThat(
        LongestConsecutiveSequence.longestConsecutiveHashMap(new int[]{100, 4, 200, 1, 3, 2})
    ).isEqualTo(4);
    assertThat(
        LongestConsecutiveSequence.longestConsecutiveHashMap(new int[]{4, 0, -4, -2, 2, 5, 2, 0, -8, -8, -8, -8, -1, 7, 4, 5, 5, -4, 6, 6, -3})
    ).isEqualTo(5);
  }

  @Test
  public void longestConsecutiveSet() {
    assertThat(
        LongestConsecutiveSequence.longestConsecutiveSet(new int[]{100, 4, 200, 1, 3, 2})
    ).isEqualTo(4);
    assertThat(
        LongestConsecutiveSequence.longestConsecutiveHashMap(new int[]{4, 0, -4, -2, 2, 5, 2, 0, -8, -8, -8, -8, -1, 7, 4, 5, 5, -4, 6, 6, -3})
    ).isEqualTo(5);
  }
}
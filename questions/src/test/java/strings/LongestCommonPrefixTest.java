package strings;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class LongestCommonPrefixTest {

  @Test
  public void longestCommonPrefix() {
    assertThat(
        LongestCommonPrefix.longestCommonPrefix(new String[]{"flower", "flow", "flight"})
    ).isEqualTo("fl");
    assertThat(
        LongestCommonPrefix.longestCommonPrefix(new String[]{"dog", "racecar", "car"})
    ).isEqualTo("");
    assertThat(
        LongestCommonPrefix.longestCommonPrefix(new String[]{""})
    ).isEqualTo("");
    assertThat(
        LongestCommonPrefix.longestCommonPrefix(new String[]{"aa", "a"})
    ).isEqualTo("a");
  }
}
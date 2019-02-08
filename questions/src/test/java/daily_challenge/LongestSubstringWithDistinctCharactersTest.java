package daily_challenge;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class LongestSubstringWithDistinctCharactersTest {

  @Test
  public void length() {
    assertThat(LongestSubstringWithDistinctCharacters.length("a", 1)).isEqualTo(1);
    assertThat(LongestSubstringWithDistinctCharacters.length("a", 2)).isEqualTo(1);
    assertThat(LongestSubstringWithDistinctCharacters.length("ab", 1)).isEqualTo(1);
    assertThat(LongestSubstringWithDistinctCharacters.length("ab", 2)).isEqualTo(2);
    assertThat(LongestSubstringWithDistinctCharacters.length("abcba", 2)).isEqualTo(3);
    assertThat(LongestSubstringWithDistinctCharacters.length("aaaaaaa", 1)).isEqualTo(7);
  }
}
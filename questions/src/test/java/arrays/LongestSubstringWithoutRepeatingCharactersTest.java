package arrays;

import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class LongestSubstringWithoutRepeatingCharactersTest {

  @Test
  public void lengthOfLongestSubstring() {
    LongestSubstringWithoutRepeatingCharacters solution = new LongestSubstringWithoutRepeatingCharacters();

    assertThat(solution.lengthOfLongestSubstring("abcabcbb")).isEqualTo(3);
    assertThat(solution.lengthOfLongestSubstring("bbbbb")).isEqualTo(1);
    assertThat(solution.lengthOfLongestSubstring("pwwkew")).isEqualTo(3);
  }
}
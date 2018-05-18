package recursions_dynamic_programming;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class LongestPalindromicSubstringTest {

  @Test
  public void longestPalindrome() {
    assertThat(LongestPalindromicSubstring.longestPalindrome("babad")).isEqualTo("aba");
    assertThat(LongestPalindromicSubstring.longestPalindrome("cbbd")).isEqualTo("bb");
  }
}
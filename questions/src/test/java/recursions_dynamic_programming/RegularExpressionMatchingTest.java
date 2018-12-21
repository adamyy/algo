package recursions_dynamic_programming;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class RegularExpressionMatchingTest {

  @Test
  public void isMatch() {
    assertThat(RegularExpressionMatching.isMatch("aa", "a")).isFalse();
    assertThat(RegularExpressionMatching.isMatch("aa", "a*")).isTrue();
    assertThat(RegularExpressionMatching.isMatch("ab", ".*")).isTrue();
    assertThat(RegularExpressionMatching.isMatch("aab", "c*a*b")).isTrue();
    assertThat(RegularExpressionMatching.isMatch("mississi", "mis*is*")).isFalse();
    assertThat(RegularExpressionMatching.isMatch("mississippi", "mis*is*p*.")).isFalse();
  }
}
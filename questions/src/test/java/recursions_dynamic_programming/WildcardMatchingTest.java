package recursions_dynamic_programming;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class WildcardMatchingTest {

  @Test
  public void isMatch() {
    assertThat(WildcardMatching.isMatch("aa", "a")).isFalse();
    assertThat(WildcardMatching.isMatch("aa", "*")).isTrue();
    assertThat(WildcardMatching.isMatch("cb", "?a")).isFalse();
    assertThat(WildcardMatching.isMatch("adceb", "*a*b")).isTrue();
    assertThat(WildcardMatching.isMatch("acdcb", "a*c?b")).isFalse();
  }
}
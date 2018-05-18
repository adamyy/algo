package recursions_dynamic_programming;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class PalindromicSubstringsTest {

  @Test
  public void countSubstrings() {
    assertThat(PalindromicSubstrings.countSubstrings("abc")).isEqualTo(3);
    assertThat(PalindromicSubstrings.countSubstrings("aaa")).isEqualTo(6);
  }
}
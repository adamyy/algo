package hashtables;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class MinimumWindowSubstringTest {

  @Test
  public void minWindow() {
    assertThat(MinimumWindowSubstring.minWindow("ADOBECODEBANC", "ABC")).isEqualTo("BANC");
    assertThat(MinimumWindowSubstring.minWindow("ADOBECODEBANC", "OO")).isEqualTo("OBECO");
  }
}
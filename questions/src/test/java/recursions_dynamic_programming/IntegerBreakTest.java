package recursions_dynamic_programming;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class IntegerBreakTest {

  @Test
  public void integerBreak() {
    assertThat(IntegerBreak.integerBreak(2)).isEqualTo(1);
    assertThat(IntegerBreak.integerBreak(10)).isEqualTo(36);
  }
}
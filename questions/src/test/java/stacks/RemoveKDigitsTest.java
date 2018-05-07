package stacks;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class RemoveKDigitsTest {

  @Test
  public void removeKDigits() {
    assertThat(RemoveKDigits.removeKDigits("1432219", 3)).isEqualTo("1219");
    assertThat(RemoveKDigits.removeKDigits("10200", 1)).isEqualTo("200");
    assertThat(RemoveKDigits.removeKDigits("10", 2)).isEqualTo("0");
  }
}
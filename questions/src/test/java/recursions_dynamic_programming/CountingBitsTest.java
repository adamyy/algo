package recursions_dynamic_programming;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class CountingBitsTest {

  @Test
  public void countBits() {
    assertThat(CountingBits.countBitsExplained(5)).asList()
        .containsExactly(0, 1, 1, 2, 1, 2);
  }
}
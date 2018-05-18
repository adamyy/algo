package recursions_dynamic_programming;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class TargetSumTest {

  @Test
  public void findTargetSumWays() {
    assertThat(TargetSum.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3))
        .isEqualTo(5);
  }

  @Test
  public void findTargetSumExplained() {
    assertThat(TargetSum.findTargetSumExplained(new int[]{1, 1, 1, 1, 1}, 3))
        .isEqualTo(5);
  }
}
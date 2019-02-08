package stacks;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class TrappingRainWaterTest {

  @Test
  public void trap() {
    assertThat(TrappingRainWater.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1})).isEqualTo(6);
  }
}
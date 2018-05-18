package recursions_dynamic_programming;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class ClimbingStairsTest {

  @Test
  public void climbStairs() {
    assertThat(ClimbingStairs.climbStairs(2)).isEqualTo(2);
    assertThat(ClimbingStairs.climbStairs(3)).isEqualTo(3);
  }
}
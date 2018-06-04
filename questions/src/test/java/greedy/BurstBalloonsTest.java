package greedy;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class BurstBalloonsTest {

  @Test
  public void findMinArrowShots() {
    assertThat(BurstBalloons.findMinArrowShots(new int[][]{
        {10, 16}, {2, 8}, {1, 6}, {7, 12}
    })).isEqualTo(2);
  }
}
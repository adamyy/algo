package recursions_dynamic_programming;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class HouseRobberRingNeighbourhoodTest {

  @Test
  public void robRingNeighbourhood() {
    assertThat(HouseRobberRingNeighbourhood.robRingNeighbourhood(new int[]{2, 3, 2}))
        .isEqualTo(3);
    assertThat(HouseRobberRingNeighbourhood.robRingNeighbourhood(new int[]{1, 2, 3, 1}))
        .isEqualTo(4);
  }
}
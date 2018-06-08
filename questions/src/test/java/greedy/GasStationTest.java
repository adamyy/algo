package greedy;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class GasStationTest {

  @Test
  public void canCompleteCircuit() {
    assertThat(GasStation.canCompleteCircuit(
        new int[]{1, 2, 3, 4, 5},
        new int[]{3, 4, 5, 1, 2})
    ).isEqualTo(3);

    assertThat(GasStation.canCompleteCircuit(
        new int[]{2, 3, 4},
        new int[]{3, 4, 3})
    ).isEqualTo(-1);

    assertThat(GasStation.canCompleteCircuit(
        new int[]{5, 5, 1, 3, 4},
        new int[]{8, 1, 7, 1, 1})
    ).isEqualTo(3);

    assertThat(GasStation.canCompleteCircuit(
        new int[]{5, 8, 2, 8},
        new int[]{6, 5, 6, 6})
    ).isEqualTo(3);
  }
}
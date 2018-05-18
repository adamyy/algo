package recursions_dynamic_programming;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class HouseRobberTest {

  @Test
  public void rob() {
    assertThat(HouseRobber.rob(new int[]{1, 2, 3, 1})).isEqualTo(4);
    assertThat(HouseRobber.rob(new int[]{2, 7, 9, 3, 1})).isEqualTo(12);
  }
}
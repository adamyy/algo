package recursions_dynamic_programming;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class FewestCoinChangeTest {

  @Test
  public void coinChange() {
    assertThat(FewestCoinChange.coinChange(new int[]{1, 2, 5}, 11)).isEqualTo(3);
    assertThat(FewestCoinChange.coinChange(new int[]{2}, 3)).isEqualTo(-1);
  }
}
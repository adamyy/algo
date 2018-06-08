package recursions_dynamic_programming;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class CoinChangeTest {

  @Test
  public void coinChange() {
    assertThat(CoinChange.coinChange(3, new int[]{2})).isEqualTo(-1);
    assertThat(CoinChange.coinChange(5, new int[]{1, 2, 5})).isEqualTo(8);
  }

  @Test
  public void coinChangeKnapsack() {
    assertThat(CoinChange.coinChangeKnapsack(3, new int[]{2})).isEqualTo(-1);
    assertThat(CoinChange.coinChangeKnapsack(5, new int[]{1, 2, 5})).isEqualTo(8);
  }
}
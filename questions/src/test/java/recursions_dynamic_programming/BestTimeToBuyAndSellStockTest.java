package recursions_dynamic_programming;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class BestTimeToBuyAndSellStockTest {

  @Test
  public void maxProfit() {
    assertThat(BestTimeToBuyAndSellStock.maxProfit(new int[]{7, 1, 5, 3, 6, 4}))
        .isEqualTo(5);
    assertThat(BestTimeToBuyAndSellStock.maxProfit(new int[]{7, 6, 4, 3, 1}))
        .isEqualTo(0);
  }
}
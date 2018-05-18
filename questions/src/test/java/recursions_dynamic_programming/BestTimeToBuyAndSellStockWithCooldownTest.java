package recursions_dynamic_programming;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class BestTimeToBuyAndSellStockWithCooldownTest {

  @Test
  public void maxProfit() {
    assertThat(BestTimeToBuyAndSellStockWithCooldown.maxProfit(new int[]{1, 2, 3, 0, 2}))
        .isEqualTo(3);
  }

  @Test
  public void maxProfitSimplified() {
    assertThat(BestTimeToBuyAndSellStockWithCooldown.maxProfitSimplified(new int[]{1, 2, 3, 0, 2}))
        .isEqualTo(3);
    assertThat(BestTimeToBuyAndSellStockWithCooldown.maxProfitSimplified(new int[]{1, 2, 4}))
        .isEqualTo(3);
  }
}
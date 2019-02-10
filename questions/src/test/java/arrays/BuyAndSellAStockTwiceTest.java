package arrays;

import org.junit.Test;

import java.util.Arrays;

import static com.google.common.truth.Truth.assertThat;

public class BuyAndSellAStockTwiceTest {

  @Test
  public void computeMaxProfit() {
    assertThat(BuyAndSellAStockTwice.computeMaxProfit(Arrays.asList(12.0, 11.0, 13.0, 9.0, 12.0, 8.0, 14.0, 13.0, 15.0)))
        .isEqualTo(10.0);
  }
}
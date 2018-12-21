package array;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class StockTradeTest {

  @Test
  public void maxProfit() {
    assertThat(StockTrade.maxProfit(new int[]{310, 315, 275, 295, 260, 270, 290, 230, 255, 250}))
        .isEqualTo(30);
  }

  @Test
  public void maxProfitTwoTrades() {
    assertThat(StockTrade.maxProfitTwoTrades(new int[]{12, 11, 13, 9, 12, 8, 14, 13, 15}))
        .isEqualTo(10);
  }

  @Test
  public void maxProfitTwoTradesConstantSpace() {
    assertThat(StockTrade.maxProfitTwoTradesConstantSpace(new int[]{12, 11, 13, 9, 12, 8, 14, 13, 15}))
        .isEqualTo(10);
  }
}
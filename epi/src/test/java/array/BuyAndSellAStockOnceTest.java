package array;

import array.BuyAndSellAStockOnce;
import org.junit.Test;

import java.util.Arrays;

import static com.google.common.truth.Truth.*;

public class BuyAndSellAStockOnceTest {

  @Test
  public void computeMaxProfit() {
    assertThat(
        BuyAndSellAStockOnce.computeMaxProfit(Arrays.asList(310.0, 315.0, 275.9, 295.0, 260.0, 270.0, 290.0, 230.0, 255.0, 250.0))
    ).isEqualTo(30.0);
  }
}
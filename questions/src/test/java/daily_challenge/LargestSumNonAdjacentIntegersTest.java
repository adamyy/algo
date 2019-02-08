package daily_challenge;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class LargestSumNonAdjacentIntegersTest {

  @Test
  public void max() {
    assertThat(LargestSumNonAdjacentIntegers.max(new int[]{2, 4, 6, 2, 5})).isEqualTo(13);
    assertThat(LargestSumNonAdjacentIntegers.max(new int[]{5, 1, 1, 5})).isEqualTo(10);
    assertThat(LargestSumNonAdjacentIntegers.max(new int[]{-1})).isEqualTo(0);
    assertThat(LargestSumNonAdjacentIntegers.max(new int[]{-1, -2, 4, -3, -5})).isEqualTo(4);
  }
}
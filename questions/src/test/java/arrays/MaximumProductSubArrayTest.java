package arrays;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class MaximumProductSubArrayTest {

  @Test
  public void product() {
    assertThat(MaximumProductSubArray.product(new int[]{2, 3, -2, 4})).isEqualTo(6);
    assertThat(MaximumProductSubArray.product(new int[]{-2, 0, -1})).isEqualTo(0);
    assertThat(MaximumProductSubArray.product(new int[]{6, -3, -10, 0, 2})).isEqualTo(180);
    assertThat(MaximumProductSubArray.product(new int[]{-1, -3, -10, 0, 60})).isEqualTo(60);
    assertThat(MaximumProductSubArray.product(new int[]{-2, -3, 0, -2, -40})).isEqualTo(80);
  }
}
package recursions_dynamic_programming;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class MaximumSubarrayTest {

  @Test
  public void maxSubarrayDivideAndConquer() {
    assertThat(MaximumSubarray.maxSubarrayDivideAndConquer(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}))
        .isEqualTo(6);
  }

  @Test
  public void maxSubarrayGreedy() {
    assertThat(MaximumSubarray.maxSubarrayGreedy(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}))
        .isEqualTo(6);
  }
}
package arrays;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class ShortestUnsortedContinuousSubarrayTest {

  @Test
  public void findUnsortedSubarray() {
    assertThat(
        ShortestUnsortedContinuousSubarray.findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15})
    ).isEqualTo(5);
  }
}
package linkedlists;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class SlidingWindowMaximumTest {

  @Test
  public void maxSlidingWindow() {
    assertThat(SlidingWindowMaximum.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3))
        .isEqualTo(new int[]{3, 3, 5, 5, 6, 7});
  }
}
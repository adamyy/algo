package greedy;

import java.util.Arrays;
import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class SmallestUnconstructibleValueTest {

  @Test
  public void smallestUnconstructibleValue() {
    assertThat(SmallestUnconstructibleValue.smallestUnconstructibleValue(Arrays.asList(12, 2, 1, 15, 2, 4)))
        .isEqualTo(10);
  }
}
package dynamic_programming;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class WeightedJobSchedulingTest {

  @Test
  public void maximumProfit() {
    assertThat(WeightedJobScheduling.maximumProfit(new Job[]{
        new Job(1, 2, 50),
        new Job(3, 5, 20),
        new Job(6, 9, 100),
        new Job(2, 100, 200)
    })).isEqualTo(250);
  }
}
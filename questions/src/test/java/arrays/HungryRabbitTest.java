package arrays;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class HungryRabbitTest {

  @Test
  public void carrotsEaten() {
    int[][] garden = {
        {5, 7, 8, 6, 3},
        {0, 0, 7, 0, 4},
        {4, 6, 3, 4, 9},
        {3, 1, 0, 5, 8}
    };
    assertThat(HungryRabbit.carrotsEaten(garden)).isEqualTo(27);
  }
}
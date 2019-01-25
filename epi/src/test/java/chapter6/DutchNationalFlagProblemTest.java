package chapter6;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class DutchNationalFlagProblemTest {

  @Test
  public void arrange() {
    int[] arr = { 0, 1, 2, 0, 2, 1, 1 };
    DutchNationalFlagProblem solution = new DutchNationalFlagProblem();
    solution.arrange(arr, 3);
    assertThat(arr).isEqualTo(new int[]{ 0, 0, 2, 2, 1, 1, 1 });
  }
}
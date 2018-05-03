package hashtables;

import org.junit.Test;

import static org.junit.Assert.*;

public class TwoSumTest {

  @Test
  public void twoSum() {
    TwoSum solution = new TwoSum();

    assertArrayEquals(solution.twoSum(new int[]{2, 7, 11, 15}, 9), new int[] {0, 1});
  }
}
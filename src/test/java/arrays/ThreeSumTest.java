package arrays;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;

public class ThreeSumTest {

  @Test
  public void threeSum() {
    ThreeSum solution = new ThreeSum();

    List<List<Integer>> resultList = solution.threeSum(new int[]{ -1, 0, 1, 2, -1, -4 });
    assertThat(resultList).containsNoDuplicates();
    assertThat(resultList).containsAllOf(Arrays.asList(-1, 0, 1), Arrays.asList(-1, -1, 2));
  }
}
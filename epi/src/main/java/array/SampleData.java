package array;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class SampleData {

  /**
   * Implement an algorithm that takes as input an array of distinct elements and a size,
   * and returns a subset of the given size of the array elements.
   * All subsets should be equally likely. Return the result in input array itself.
   */
  public static void randomSampling(List<Integer> list, int k) {
    Random random = new Random();
    for (int i = 0; i < k; ++i) {
      Collections.swap(list, i, i + random.nextInt(list.size() - i));
    }
  }
}

package greedy;

import java.util.Collections;
import java.util.List;

/**
 * Takes an array of positive integers and returns the smallest number
 * which is not to the sum of a subset of elements of the array.
 */
public class SmallestUnconstructibleValue {
  public static int smallestUnconstructibleValue(List<Integer> list) {
    Collections.sort(list);
    int maxConstructibleValue = 0;
    for (int num : list) {
      if (num > maxConstructibleValue + 1) break;
      maxConstructibleValue += num;
    }
    return maxConstructibleValue + 1;
  }
}

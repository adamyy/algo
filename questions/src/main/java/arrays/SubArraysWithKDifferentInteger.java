package arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array A of positive integers,
 * call a (contiguous, not necessarily distinct) subarray of A good
 * if the number of different integers in that subarray is exactly K.
 *
 * (For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.)
 *
 * Return the number of good subarrays of A.
 *
 *
 *
 * Example 1:
 *
 * Input: A = [1,2,1,2,3], K = 2
 * Output: 7
 * Explanation: Subarrays formed with exactly 2 different integers:
 * [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2].
 *
 * Example 2:
 *
 * Input: A = [1,2,1,3,4], K = 3
 * Output: 3
 * Explanation: Subarrays formed with exactly 3 different integers: [1,2,1,3], [2,1,3], [1,3,4].
 *
 *
 * Note:
 *
 * 1 <= A.length <= 20000
 * 1 <= A[i] <= A.length
 * 1 <= K <= A.length
 */
public class SubArraysWithKDifferentInteger {
  // hint: exactly k = at most k - at most (k - 1)
  public static int subArraysWithKDistinct(int[] arr, int k) {
    return subArraysWithAtMostKDistinct(arr, k) - subArraysWithAtMostKDistinct(arr, k - 1);
  }

  private static int subArraysWithAtMostKDistinct(int[] arr, int k) {
    int requiredDistinct = k;
    int start = 0, end = 0;
    int result = 0;
    Map<Integer, Integer> count = new HashMap<>();
    while (end < arr.length) {
      if (count.getOrDefault(arr[end], 0) == 0) requiredDistinct--;
      count.put(arr[end], count.getOrDefault(arr[end], 0) + 1);
      while (requiredDistinct < 0) {
        // if we got more distinct numbers than we want
        // we shrinks the array
        count.put(arr[start], count.get(arr[start]) - 1);
        if (count.get(arr[start]) == 0) requiredDistinct++; // we completely removed a distinct number
        start++;
      }
      // any sub-array that is within end to start (e.g., (start, end), (start + 1, end), etc),
      // contains at most k distinct characters
      result += end - start + 1;
      end++;
    }
    return result;
  }
}

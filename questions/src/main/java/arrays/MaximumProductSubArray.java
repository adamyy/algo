package arrays;

/**
 * Given an integer array nums, find the contiguous subarray within an array
 * (containing at least one number) which has the largest product.
 *
 * Example 1:
 *
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * Example 2:
 *
 * Input: [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 *
 * Expected Time complexity is O(n) and only O(1) extra space can be used.
 */
public class MaximumProductSubArray {
  public static int product(int[] arr) {
    int maxEndingHere = 0;
    int minEndingHere = 0;
    int maxSoFar = 0;
    for (int num: arr) {
      if (num > 0) {
        maxEndingHere = Math.max(maxEndingHere * num, num);
        minEndingHere = Math.min(minEndingHere * num, num);
      } else {
        int newMaxEndingHere = Math.max(minEndingHere * num, num);
        minEndingHere = Math.min(maxEndingHere * num, num);
        maxEndingHere = newMaxEndingHere;
      }
      maxSoFar = Math.max(maxEndingHere, maxSoFar);
    }
    return maxSoFar;
  }
}

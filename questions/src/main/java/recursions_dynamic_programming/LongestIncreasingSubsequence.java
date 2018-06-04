package recursions_dynamic_programming;

/**
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 * <p>
 * For example,
 * Given [10, 9, 2, 5, 3, 7, 101, 18],
 * The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4.
 * Note that there may be more than one LIS combination, it is only necessary for you to return the length.
 * <p>
 * Your algorithm should run in O(n2) complexity.
 * <p>
 * Follow up: Could you improve it to O(n log n) time complexity?
 */
public class LongestIncreasingSubsequence {
  /**
   * Constant space
   * O(n^2) runtime
   */
  public static int lengthOfLISBruteForce(int[] nums) {
    int max = 0;
    for (int i = 0; i < nums.length; i++) {
      int curr = nums[i];
      int length = 1;
      for (int j = i; j < nums.length; j++) {
        if (nums[j] > curr) {
          curr = nums[j];
          length++;
        }
      }
      max = Math.max(max, length);
    }
    return max;
  }

  /**
   * tails is an array storing the smallest tail of all increasing subsequences with length i+1 in tails[i].
   * For example, say we have nums = [4,5,6,3], then all the available increasing subsequences are:
   *
   * len = 1   :      [4], [5], [6], [3]   => tails[0] = 3
   * len = 2   :      [4, 5], [5, 6]       => tails[1] = 5
   * len = 3   :      [4, 5, 6]            => tails[2] = 6
   *
   * We can easily prove that tails is a increasing array.
   * Therefore it is possible to do a binary search in tails array to find the one needs update.
   *
   * Each time we only do one of the two:
   *
   * (1) if x is larger than all tails, append it, increase the size by 1
   * (2) if tails[i-1] < x <= tails[i], update tails[i]
   * Doing so will maintain the tails invariant. The the final answer is just the size.
   */
  public static int lengthOfLISTails(int[] nums) {
    int[] tails = new int[nums.length];
    int length = 0;
    for (int curr : nums) {
      int start = 0, end = length;
      while (start != end) {
        int mid = (start + end) / 2;
        if (tails[mid] < curr) {
          start = mid + 1;
        } else {
          end = mid;
        }
      }
      tails[start] = curr;
      if (start == length) length++;
    }
    return length;
  }

  /**
   * 1, traverse from 0 to len-1, the DP array keep the longest sequence.
   * 2, if the val is bigger than largest in the dp array, add it to the end;
   * 3, if it is among the sequence, return the pos that bigger than pres,
   * update the array with this position if val is smaller than dp[pos];
   * This is to keep the sequence element with the smallest number.
   *
   * Note that the sequence do not actually maintain the underlying longest increasing
   * sequence, it is there to help us track the length of longest increasing sequence.
   * The sequence could be wrong, but the length is correct.
   */
  public static int lengthOfLISBinarySearch(int[] nums) {
    if (nums == null || nums.length == 0) return 0;
    int[] sequence = new int[nums.length];
    int length = 0;
    sequence[0] = nums[0];
    for (int i = 1; i < nums.length; i++) {
      int curr = nums[i];
      int index = binarySearch(sequence, length, curr);
      if (curr < sequence[index]) sequence[index] = curr;
      if (index > length) {
        sequence[index] = curr;
        length = index;
      }
    }
    return length + 1;
  }

  private static int binarySearch(int[] sequence, int length, int target) {
    // if the target value is bigger than the maximum, append the value
    if (sequence[length] < target) return length + 1;

    // if the target is amount the sequence, find the smallest element that is bigger than target
    int start = 0;
    int end = length;
    while (start + 1 < end) {
      int mid = (start + end) / 2;
      if (sequence[mid] == target) return mid;
      if (sequence[mid] < target) start = mid;
      if (sequence[mid] > target) end = mid;
    }

    if (sequence[start] >= target) return start;
    return end;
  }
}

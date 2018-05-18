package recursions_dynamic_programming;

/**
 * Given an integer array nums, find the contiguous subarray
 * (containing at least one number) which has the largest sum and return its sum.
 * Example:
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * Follow up:
 * If you have figured out the O(n) solution,
 * try coding another solution using the divide and conquer approach, which is more subtle.
 */
public class MaximumSubarray {

  public static int maxSubarrayGreedy(int[] nums) {
    int maxSoFar = nums[0];
    int maxEndingHere = nums[0];

    for (int i = 1; i < nums.length; i++) {
      maxEndingHere = Math.max(maxEndingHere + nums[i], nums[i]);
      maxSoFar = Math.max(maxSoFar, maxEndingHere);
    }

    return maxSoFar;
  }

  public static int maxSubarrayDivideAndConquer(int[] nums) {
    if (nums == null || nums.length == 0) return 0;
    return maxSubarrayDivideAndConquer(nums, 0, nums.length - 1);
  }

  // TODO
  private static int maxSubarrayDivideAndConquer(int[] nums, int start, int end) {
    if (start > end) return 0;
    if (start == end) return nums[start];
    int mid = (start + end) / 2;

    int maxLeft = maxSubarrayDivideAndConquer(nums, start, mid - 1);
    int maxRight = maxSubarrayDivideAndConquer(nums, mid + 1, end);
    int midElem = nums[mid];

    return 0;
  }

  private static int max(int... nums) {
    int max = Integer.MIN_VALUE;
    for (int num : nums) max = Math.max(num, max);
    return max;
  }
}

package arrays;

/**
 * Given an integer array, you need to find one continuous subarray
 * that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.
 * <p>
 * You need to find the shortest such subarray and output its length.
 * <p>
 * Example 1:
 * <p>
 * Input: [2, 6, 4, 8, 10, 9, 15]
 * Output: 5
 * Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
 * <p>
 * Note:
 * <p>
 * Then length of the input array is in range [1, 10,000].
 * The input array may contain duplicates, so ascending order here means <=.
 */
public class ShortestUnsortedContinuousSubarray {
  public static int findUnsortedSubarray(int[] nums) {
    if (nums == null || nums.length <= 1) return 0;

    boolean flag = false;

    int min = Integer.MAX_VALUE;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i - 1] > nums[i]) flag = true;
      if (flag) min = Math.min(min, nums[i]);
    }

    flag = false;
    int max = Integer.MIN_VALUE;
    for (int i = nums.length - 2; i >= 0; i--) {
      if (nums[i + 1] < nums[i]) flag = true;
      if (flag) max = Math.max(max, nums[i]);
    }

    // find the element that is bigger than min
    int minIndex = 0;
    while (minIndex < nums.length && nums[minIndex] <= min) minIndex++;

    // find the element that is smaller
    int maxIndex = nums.length - 1;
    while (maxIndex >= 0 && nums[maxIndex] >= max) maxIndex--;

    return maxIndex - minIndex >= 0 ? maxIndex - minIndex + 1 : 0;
  }
}

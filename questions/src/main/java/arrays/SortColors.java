package arrays;

import java.util.Arrays;

/**
 * Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent,
 * with the colors in the order red, white and blue.
 *
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 *
 * Note: You are not suppose to use the library's sort function for this problem.
 *
 * Example:
 *
 * Input: [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * Follow up:
 *
 * A rather straight forward solution is a two-pass algorithm using counting sort.
 * First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
 * Could you come up with a one-pass algorithm using only constant space?
 */
public class SortColors {
  public static int[] sortColors(int[] nums) {
    int redIndex = 0;
    int blueIndex = nums.length - 1;
    for (int i = 0; i <= blueIndex; i++) {
      System.out.println(String.format("redIndex: %d", redIndex));
      System.out.println(String.format("blueIndex: %d", blueIndex));
      int color = nums[i];
      if (color == RED) {
        swap(nums, i, redIndex++);
      } else if (color == BLUE) {
        swap(nums, i--, blueIndex--);
      }
    }
    return nums;
  }

  private static final int RED = 0;
  private static final int WHITE = 1;
  private static final int BLUE = 2;

  private static void swap(int[] nums, int first, int second) {
    int temp = nums[first];
    nums[first] = nums[second];
    nums[second] = temp;
    System.out.println(Arrays.toString(nums));
  }
}

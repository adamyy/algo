package arrays;

/**
 * Given an array nums, write a function to move all 0's to the end of it
 * while maintaining the relative order of the non-zero elements.
 *
 * Example:
 *
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Note:
 *
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 */
public class MoveZeroes {
  public static int[] moveZeroes(int[] nums) {
    int replaceIndex = 0;
    for (int index = 0; index < nums.length; index++) {
      if (nums[index] == 0) continue;
      nums[replaceIndex++] = nums[index];
      nums[index] = 0;
    }

    return nums;
  }
}
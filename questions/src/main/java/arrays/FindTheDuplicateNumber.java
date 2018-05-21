package arrays;

/**
 * Given an array nums containing n integers where each integer is between 1 and n - 1 (inclusive),
 * prove that at least one duplicate number must exist.
 * Assume that there is only one duplicate number, find the duplicate one.
 *
 * Example 1:
 *
 * Input: [1,3,4,2,2]
 * Output: 2
 * Example 2:
 *
 * Input: [3,1,3,4,2]
 * Output: 3
 * Note:
 *
 * You must not modify the array (assume the array is read only).
 * You must use only constant, O(1) extra space.
 * Your runtime complexity should be less than O(n2).
 * There is only one duplicate number in the array, but it could be repeated more than once.
 */
public class FindTheDuplicateNumber {
  // Similar to how to find the beginning of the loop within a linked list
  public static int findDuplicate(int[] nums) {
    int n = nums.length;
    int slow = n, fast = n;

    do {
      slow = nums[slow - 1];
      fast = nums[nums[fast - 1] - 1];
    } while (slow != fast);

    // now fast and slow are same distance away from the loop start

    slow = n;
    while (slow != fast) {
      slow = nums[slow - 1];
      fast = nums[fast - 1];
    }

    return slow;
  }
}

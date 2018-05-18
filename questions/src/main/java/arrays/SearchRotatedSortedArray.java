package arrays;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 *
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 *
 * You may assume no duplicate exists in the array.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * Example 1:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * Example 2:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 */
public class SearchRotatedSortedArray {
  public static int search(int[] nums, int target) {
    if (nums.length == 0) return -1;
    int pivot = nums[0] <= nums[nums.length - 1] ? 0 : findPivot(nums, 0, nums.length - 1);

    if (target == nums[pivot]) return pivot;
    if (target >= nums[0] && target < nums[pivot]) {
      return search(nums, target, 0, pivot - 1);
    } else {
      return search(nums, target, pivot + 1, nums.length - 1);
    }
  }

  /**
   * O(log(n))
   * @return the index of the element using binary search
   */
  private static int search(int[] nums, int target, int start, int end) {
    if (start > end) return -1;
    int mid = (start + end) / 2;
    if (target > nums[mid]) return search(nums, target, mid + 1, end);
    if (target < nums[mid]) return search(nums, target, start, mid - 1);
    return mid;
  }

  /**
   * O(log(n))
   * @return the index of the pivot
   */
  private static int findPivot(int[] nums, int start, int end) {
    if (start > end) return -1;

    int mid = (start + end) / 2;
    if (nums[mid] > nums[mid + 1]) return mid;

    if (nums[start] > nums[mid]) {
      return findPivot(nums, start, mid - 1);
    } else {
      return findPivot(nums, mid + 1, end);
    }
  }
}

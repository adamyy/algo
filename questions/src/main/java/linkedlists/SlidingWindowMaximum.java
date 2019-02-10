package linkedlists;

import tags.ArrayIndex;

import java.util.LinkedList;

/**
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.
 *
 * Example:
 *
 * Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 *
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array.
 *
 * Follow up:
 * Could you solve it in linear time?
 */
public class SlidingWindowMaximum {
  @ArrayIndex
  public static int[] maxSlidingWindow(int[] nums, int k) {
    if (nums.length == 0) return new int[]{};

    int[] result = new int[nums.length - k + 1];
    int resultIndex = 0;
    LinkedList<Integer> list = new LinkedList<>();

    for (int i = 0; i < nums.length; i++) {
      // remove elements from head that are outside the window
      while (!list.isEmpty() && list.peekFirst() < i - k + 1) list.removeFirst();
      // remove elements from tail that are smaller than current elements
      while (!list.isEmpty() && nums[list.peekLast()] < nums[i]) list.removeLast();
      // add element
      list.addLast(i);
      // append result
      if (i >= k - 1) { // we store values starting from k - 1
        result[resultIndex++] = nums[list.peekFirst()];
      }
    }

    return result;
  }
}

package hashtables;

import java.util.*;

/**
 * Given two arrays, write a function to compute their intersection.
 * <p>
 * Example:
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
 * <p>
 * Note:
 * Each element in the result should appear as many times as it shows in both arrays.
 * The result can be in any order.
 * <p>
 * Follow up:
 * What if the given array is already sorted? How would you optimize your algorithm?
 * What if nums1's size is small compared to nums2's size? Which algorithm is better?
 * What if elements of nums2 are stored on disk,
 * and the memory is limited such that you cannot load all elements into the memory at once?
 */
public class IntersectionOfTwoArrays {
  public static int[] intersect(int[] nums1, int[] nums2) {
    HashMap<Integer, Integer> freq1 = new HashMap<>();
    HashMap<Integer, Integer> freq2 = new HashMap<>();

    for (int num : nums1) freq1.put(num, freq1.getOrDefault(num, 0) + 1);
    for (int num : nums2) freq2.put(num, freq2.getOrDefault(num, 0) + 1);

    for (Map.Entry<Integer, Integer> entry : freq1.entrySet()) {
      freq1.put(entry.getKey(), Math.min(entry.getValue(), freq2.getOrDefault(entry.getKey(), 0)));
    }

    int resultSize = 0;
    for (int count : freq1.values()) resultSize += count;

    int[] result = new int[resultSize];
    int index = 0;
    for (Map.Entry<Integer, Integer> entry : freq1.entrySet()) {
      if (entry.getValue() == 0) continue;
      Arrays.fill(result, index, index + entry.getValue(), entry.getKey());
      index += entry.getValue();
    }

    return result;
  }

  public static int[] intersectTwoPointers(int[] nums1, int[] nums2) {
    Arrays.sort(nums1);
    Arrays.sort(nums2);

    LinkedList<Integer> resultList = new LinkedList<>();
    int index1 = 0, index2 = 0;
    while (index1 < nums1.length && index2 < nums2.length) {
      if (nums1[index1] < nums2[index2]) {
        index1++;
      } else if (nums1[index1] > nums2[index2]) {
        index2++;
      } else {
        resultList.add(nums1[index1]);
        index1++;
        index2++;
      }
    }

    int[] arr = new int[resultList.size()];
    int index = 0;
    while (!resultList.isEmpty()) arr[index++] = resultList.remove();
    return arr;
  }
}

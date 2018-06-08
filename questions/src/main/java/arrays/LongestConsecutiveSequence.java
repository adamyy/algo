package arrays;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 *
 * Your algorithm should run in O(n) complexity.
 *
 * Example:
 *
 * Input: [100, 4, 200, 1, 3, 2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 */
public class LongestConsecutiveSequence {
  public static int longestConsecutiveHashMap(int[] nums) {
    if (nums.length == 0) return 0;

    HashMap<Integer, Integer> map = new HashMap<>();
    int max = 1;

    for (int num: nums) {
      if (map.containsKey(num)) continue;

      int leftLength = map.getOrDefault(num - 1, 0);
      int rightLength = map.getOrDefault(num + 1, 0);
      int totalLength = 1 + leftLength + rightLength;

      map.put(num, totalLength);
      map.put(num - leftLength, totalLength);
      map.put(num + rightLength, totalLength);

      max = Math.max(max, totalLength);
    }

    return max;
  }

  public static int longestConsecutiveSet(int[] nums) {
    if (nums.length == 0) return 0;

    HashSet<Integer> set = new HashSet<>();
    for (int num: nums) set.add(num);

    int max = 1;
    for (int num: nums) {
      if (set.contains(num)) {
        set.remove(num);
        int val = num;
        int length = 1;
        while (set.remove(val - 1)) {
          val--;
          length++;
        }

        val = num;
        while (set.remove(val + 1)) {
          val++;
          length++;
        }

        max = Math.max(max, length);
      }
    }

    return max;
  }
}

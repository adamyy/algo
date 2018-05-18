package hashtables;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a non-empty array of integers, return the k most frequent elements.
 * For example, given [1,1,1,2,2,3] and k = 2, return [1,2].
 *
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */
public class TopKFrequentElements {
  public static List<Integer> topKFrequent(int[] nums, int k) {
    HashMap<Integer, Integer> freqs = new HashMap<>();
    for (int i: nums) freqs.put(i, freqs.getOrDefault(i, 0) + 1);

    List<Integer>[] buckets = new List[nums.length];
    for (int key : freqs.keySet()) {
      int freq = freqs.get(key);
      if (buckets[freq] == null) buckets[freq] = new LinkedList<>();
      buckets[freq].add(key);
    }

    List<Integer> result = new LinkedList<>();
    for (int freq = buckets.length - 1; freq > 0 && k > 0; freq--) {
      if (buckets[freq] != null) {
        List<Integer> elements = buckets[freq];
        result.addAll(elements);
        k -= elements.size();
      }
    }

    return result;
  }
}

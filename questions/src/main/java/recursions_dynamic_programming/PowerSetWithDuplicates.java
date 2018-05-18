package recursions_dynamic_programming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given a collection of integers that might contain duplicates, nums,
 * return all possible subsets (the power set).
 *
 * Note: The solution set must not contain duplicate subsets.
 *
 * Example:
 *
 * Input: [1,2,2]
 * Output:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 */
public class PowerSetWithDuplicates {
  public static <T extends Comparable> List<List<T>> subsetWithDup(List<T> set) {
    Collections.sort(set);
    List<List<T>> result = new ArrayList<>(1 << set.size());
    backtrack(set, result, new ArrayList<>(), 0);
    return result;
  }

  private static <T> void backtrack(List<T> set, List<List<T>> result, List<T> temp, int start) {
    result.add(new ArrayList<>(temp));
    for (int i = start; i < set.size(); i++) {
      if (i > start && set.get(i - 1) == set.get(i)) continue;
      temp.add(set.get(i));
      backtrack(set, result, temp, i + 1);
      temp.remove(temp.size() - 1);
    }
  }
}

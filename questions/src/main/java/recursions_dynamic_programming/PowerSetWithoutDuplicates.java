package recursions_dynamic_programming;

import java.util.ArrayList;
import java.util.List;

/**
 * Write a method to return all subsets of a set.
 */
public class PowerSetWithoutDuplicates {
  public static <T> List<List<T>> getSubsets(final List<T> set) {
    int resultSize = 1 << set.size();
    List<List<T>> result = new ArrayList<>(resultSize);
    backtrack(result, set, 0, new ArrayList<>());
    return result;
  }

  private static <T> void backtrack(final List<List<T>> result,
                                    final List<T> set,
                                    final int start,
                                    final List<T> temp) {
    result.add(new ArrayList<>(temp));
    for (int i = start; i < set.size(); i++) {
      temp.add(set.get(i));
      backtrack(result, set, i + 1, temp);
      temp.remove(temp.size() - 1);
    }
  }
}

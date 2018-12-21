package recursions_dynamic_programming;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Permutations with Dups: Write a method to compute all permutations of a string whose characters are not necessarily unique.
 * The list of permutations should not have duplicates.
 */
public class PermutationsWithDuplicates {
  public static List<String> permutation(String s) {
    List<String> result = new LinkedList<>();
    char[] arr = s.toCharArray();
    Arrays.sort(arr);
    backtrack(0, arr, result);
    return result;
  }

  private static void backtrack(int start, char[] arr, List<String> result) {
    if (start == arr.length) {
      result.add(String.copyValueOf(arr));
      return;
    }

    for (int i = start; i < arr.length; i++) {
      if (i > start && arr[i] == arr[i - 1]) continue;
      swap(arr, i, start);
      backtrack(start + 1, arr, result);
      swap(arr, i, start);
    }
  }

  private static void swap(char[] arr, int x, int y) {
    char temp = arr[x];
    arr[x] = arr[y];
    arr[y] = temp;
  }
}

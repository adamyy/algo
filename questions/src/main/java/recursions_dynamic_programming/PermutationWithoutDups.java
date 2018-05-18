package recursions_dynamic_programming;

import java.util.LinkedList;
import java.util.List;

/**
 * Write a method to compute all permutations of a string of unique characters.
 */
public class PermutationWithoutDups {
  public static List<String> permutations(String s) {
    List<String> result = new LinkedList<>();
    backtrack(0, s.toCharArray(), result);
    return result;
  }

  private static void backtrack(int start, char[] target, List<String> result) {
    if (start == target.length) {
      result.add(String.copyValueOf(target));
      return;
    }

    for (int i = start; i < target.length; i++) {
      swap(target, start, i); // "take in" the ith character
      backtrack(start + 1, target, result);
      swap(target, start, i); // "remove" the ith character
    }
  }

  private static void swap(char[] arr, int x, int y) {
    char temp = arr[x];
    arr[x] = arr[y];
    arr[y] = temp;
  }
}

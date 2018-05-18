package recursions_dynamic_programming;

import java.util.ArrayList;
import java.util.List;

/**
 * Parenthesizes: Implement an algorithm to print all valid (e.g., properly opened and closed) combinations of n pairs of parentheses.
 * EXAMPLE
 * Input: 3
 * Output: ((())), (()()), (())(), ()(()), ()()()
 */
public class Parenthesizes {
  private static final char LEFT = '(';
  private static final char RIGHT = ')';

  public static List<String> parenthesizes(int pair) {
    List<String> result = new ArrayList<>();
    backtrack(pair, pair, 0, new char[pair * 2], result);
    return result;
  }

  private static void backtrack(int leftRemain, int rightRemain, int index, char[] str, List<String> result) {
    if (leftRemain == 0 && rightRemain == 0) {
      result.add(String.copyValueOf(str));
      return;
    }

    // append left
    if (leftRemain > 0) {
      str[index] = LEFT;
      backtrack(leftRemain - 1, rightRemain, index + 1, str, result);
    }

    // append right
    if (rightRemain > leftRemain) {
      str[index] = RIGHT;
      backtrack(leftRemain, rightRemain - 1, index + 1, str, result);
    }
  }
}

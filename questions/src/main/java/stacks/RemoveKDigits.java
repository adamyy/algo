package stacks;

/**
 * Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.
 *
 * Note:
 * The length of num is less than 10002 and will be ≥ k.
 * The given num does not contain any leading zero.
 * Example 1:
 *
 * Input: num = "1432219", k = 3
 * Output: "1219"
 * Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
 * Example 2:
 *
 * Input: num = "10200", k = 1
 * Output: "200"
 * Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
 * Example 3:
 *
 * Input: num = "10", k = 2
 * Output: "0"
 * Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 */
public class RemoveKDigits {
  /**
   * Question: how to remove one digit from the number s.t. the new number is the smallest possible?
   * Hint: scan from left to right and remove the first "peak" digit (larger than its right neighbor), O(n)
   *
   * Now how to remove k digits?
   */
  public static String removeKDigits(String num, int removables) {
    int digits = num.length() - removables;
    char[] stack = new char[digits];
    int top = 0;

    for (int index = 0; index < num.length(); index++) {
      char currentDigit = num.charAt(index);

      while (top > 0 && stack[top - 1] > currentDigit && removables > 0) {
        top--; // "pop" from the stack because we can remove that digit
        removables--;
      }

      if (digits > top) {
        stack[top++] = currentDigit;
      } else {
        // this code path indicates that currentDigit > stack[top - 1]
        // thus we should remove currentDigit
        removables--;
      }
    }

    int firstNonZeroIndex = 0;
    while (firstNonZeroIndex < digits && stack[firstNonZeroIndex] == '0') firstNonZeroIndex++;

    return firstNonZeroIndex == digits
        ? "0"
        : String.copyValueOf(stack, firstNonZeroIndex, digits - firstNonZeroIndex);
  }
}

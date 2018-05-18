package recursions_dynamic_programming;

/**
 * Given a string, your task is to count how many palindromic substrings in this string.
 *
 * The substrings with different start indexes or end indexes are counted as different substrings
 * even they consist of same characters.
 *
 * Example 1:
 * Input: "abc"
 * Output: 3
 * Explanation: Three palindromic strings: "a", "b", "c".
 *
 * Example 2:
 * Input: "aaa"
 * Output: 6
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 *
 * Note:
 * The input string length won't exceed 1000.
 */
public class PalindromicSubstrings {
  public static int countSubstrings(String s) {
    int count = 0;
    int n = s.length();
    boolean[][] isPalindrome = new boolean[n][n];
    for (int i = n - 1; i >= 0; i--) {
      for (int j = i; j < n; j++) {
        isPalindrome[i][j] = s.charAt(i) == s.charAt(j) && (stringLength(i, j) < 3 || isPalindrome[i + 1][j - 1]);
        if (isPalindrome[i][j]) count++;
      }
    }
    return count;
  }

  private static int stringLength(int start, int end) {
    return end - start + 1;
  }
}

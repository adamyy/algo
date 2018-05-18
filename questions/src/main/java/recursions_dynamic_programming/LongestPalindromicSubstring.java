package recursions_dynamic_programming;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * <p>
 * Example 1:
 * <p>
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * <p>
 * Example 2:
 * <p>
 * Input: "cbbd"
 * Output: "bb"
 */
public class LongestPalindromicSubstring {
  public static String longestPalindrome(String s) {
    int n = s.length();
    boolean[][] isPalindrome = new boolean[n][n];
    int maxLeft = -1, maxRight = -1;
    for (int i = n - 1; i >= 0; i--) {
      for (int j = i; j < n; j++) {
        isPalindrome[i][j] = s.charAt(i) == s.charAt(j) && ((j - i) < 3 || isPalindrome[i - 1][j + 1]);
        if (isPalindrome[i][j] && stringLength(maxLeft, maxRight) < stringLength(i, j)) {
          maxLeft = i;
          maxRight = j;
        }
      }
    }
    return s.substring(maxLeft, maxRight + 1);
  }

  private static int stringLength(int startIndex, int endIndex) {
    return endIndex - startIndex + 1;
  }
}

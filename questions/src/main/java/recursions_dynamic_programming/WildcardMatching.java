package recursions_dynamic_programming;


/**
 * Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.
 *
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * The matching should cover the entire input string (not partial).
 *
 * Note:
 *
 * s could be empty and contains only lowercase letters a-z.
 * p could be empty and contains only lowercase letters a-z, and characters like ? or *.
 * Example 1:
 *
 * Input:
 * s = "aa"
 * p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 * Example 2:
 *
 * Input:
 * s = "aa"
 * p = "*"
 * Output: true
 * Explanation: '*' matches any sequence.
 * Example 3:
 *
 * Input:
 * s = "cb"
 * p = "?a"
 * Output: false
 * Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
 * Example 4:
 *
 * Input:
 * s = "adceb"
 * p = "*a*b"
 * Output: true
 * Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".
 * Example 5:
 *
 * Input:
 * s = "acdcb"
 * p = "a*c?b"
 * Output: false
 */
public class WildcardMatching {
  public static boolean isMatch(String s, String p) {
    boolean[][] match = new boolean[s.length() + 1][p.length() + 1];
    match[0][0] = true;
    for (int j = 1; j <= p.length(); j++) {
      match[0][j] = match[0][j - 1] && p.charAt(j - 1) == '*';
    }

    for (int i = 0; i < s.length(); i++) {
      for (int j = 0; j < p.length(); j++) {
        if (s.charAt(i) == p.charAt(j)) {
          match[i + 1][j + 1] = match[i][j];
        } else if (p.charAt(j) == '?') {
          match[i + 1][j + 1] = match[i][j];
        } else if (p.charAt(j) == '*') {
          match[i + 1][j + 1] = match[i][j + 1] // match nothing
            || match[i + 1][j]; // match any char with no "cost"
        }
      }
    }

    return match[s.length()][p.length()];
  }
}

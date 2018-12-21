package recursions_dynamic_programming;

/**
 * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
 *
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 *
 * The matching should cover the entire input string (not partial).
 *
 * Note:
 *
 *     s could be empty and contains only lowercase letters a-z.
 *     p could be empty and contains only lowercase letters a-z, and characters like . or *.
 *
 * Example 1:
 *
 * Input:
 * s = "aa"
 * p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 *
 * Example 2:
 *
 * Input:
 * s = "aa"
 * p = "a*"
 * Output: true
 * Explanation: '*' means zero or more of the precedeng element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
 *
 * Example 3:
 *
 * Input:
 * s = "ab"
 * p = ".*"
 * Output: true
 * Explanation: ".*" means "zero or more (*) of any character (.)".
 *
 * Example 4:
 *
 * Input:
 * s = "aab"
 * p = "c*a*b"
 * Output: true
 * Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore it matches "aab".
 *
 * Example 5:
 *
 * Input:
 * s = "mississippi"
 * p = "mis*is*p*."
 * Output: false
 */
public class RegularExpressionMatching {
  public static boolean isMatch(String string, String pattern) {
    if (string == null || pattern == null) return false;

    boolean[][] match = new boolean[string.length() + 1][pattern.length() + 1];
    // base case: both empty
    match[0][0] = true;

    // base case extended: in the case where string is empty but pattern is not
    for (int j = 0; j < pattern.length(); j++) {
      if (pattern.charAt(j) == '*' && match[0][j - 1]) {
        match[0][j + 1] = true;
      }
    }

    // 1) if string[i] == pattern[j] then check if match[i - 1][j - 1]
    // 2) if pattern[j] == '.' then check if match[i - 1][j - 1]
    // 3) if pattern[j] == '*' then does the previous char of pattern matches that of the string?
    // 3.1) if it does not, and it is not a wild card, then check for match[i][j - 2] // because you cannot match two chars in the pattern (the previous char + current '*' char)
    // 3.2) if it does not, but it is a wild card OR if it does
    //      question: how many chars should '*' match?
    //      case 0: then check match[i][j - 2] because you essentially lose two chars (current char + '*')
    //      case 1: then check match[i][j - 1] because '*' did nothing
    //      case X: then check match[i - 1][j] because if you can match (current string - one char) then you can match current string
    for (int i = 0; i < string.length(); i++) {
      for (int j = 0; j < pattern.length(); j++) {
        if (pattern.charAt(j) == string.charAt(i)) {
          match[i + 1][j + 1] = match[i][j];
        } else if (pattern.charAt(j) == '.') {
          match[i + 1][j + 1] = match[i][j];
        } else if (pattern.charAt(j) == '*') {
          if (string.charAt(i) != pattern.charAt(j - 1) && pattern.charAt(j - 1) != '.') {
            match[i + 1][j + 1] = match[i + 1][j - 1];
          } else {
            match[i + 1][j + 1] = match[i + 1][j] || match[i + 1][j - 1] || match[i][j + 1];
          }
        }
      }
    }

    return match[string.length()][pattern.length()];
  }
}

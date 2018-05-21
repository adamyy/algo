package strings;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 * Example 1:
 *
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 *
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * Note:
 *
 * All given inputs are in lowercase letters a-z.
 */
public class LongestCommonPrefix {
  public static String longestCommonPrefix(String[] strs) {
    if (strs == null || strs.length == 0) return "";
    StringBuilder builder = new StringBuilder();
    int index = 0;
    while (true) {
      if (index >= strs[0].length()) break;
      char ch = strs[0].charAt(index);
      boolean valid = true;
      for (int i = 1; i < strs.length; i++) {
        if (index >= strs[i].length()) {
          valid = false;
          break;
        }
        char temp = strs[i].charAt(index);
        if (ch != temp) valid = false;
      }
      if (!valid) break;
      builder.append(ch);
      index++;
    }
    return builder.toString();
  }
}

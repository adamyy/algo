package hashtables;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Examples:
 *
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 *
 * Given "bbbbb", the answer is "b", with the length of 1.
 *
 * Given "pwwkew", the answer is "wke", with the length of 3.
 *
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstringWithoutRepeatingCharacters {
  public int lengthOfLongestSubstring(String s) {
    if (s == null || s.isEmpty()) return 0;

    Map<Character, Integer> indexMap = new HashMap<>();
    int max = 0;

    for (int start = 0, end = 0; end < s.length(); ++end) {
      if (indexMap.containsKey(s.charAt(end))) {
        start = Math.max(start, indexMap.get(s.charAt(end)) + 1);
      }
      indexMap.put(s.charAt(end), end);
      max = Math.max(max, end - start + 1);
    }

    return max;
  }
}

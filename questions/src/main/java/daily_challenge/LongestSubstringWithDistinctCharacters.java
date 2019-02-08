package daily_challenge;

import java.util.HashMap;
import java.util.Map;

/**
 * This problem was asked by Amazon.
 *
 * Given an integer k and a string s, find the length of the longest substring that contains at most k distinct characters.
 *
 * For example, given s = "abcba" and k = 2, the longest substring with k distinct characters is "bcb".
 */
public class LongestSubstringWithDistinctCharacters {
  public static int length(String s, int k) {
    if (s == null || k == 0) return 0;
    if (s.length() <= 1) return s.length();

    int maxLength = 0;
    int start = 0, end = 0;

    Map<Character, Integer> lastPosition = new HashMap<>(k);
    lastPosition.put(s.charAt(start), 0);

    while (++end < s.length()) {
      char endChar = s.charAt(end);

      if (!lastPosition.containsKey(endChar) && lastPosition.size() >= k) {
        // max capacity, "remove" startChar
        start = lastPosition.remove(s.charAt(start)) + 1;
      }

      lastPosition.put(endChar, end);
      maxLength = Math.max(maxLength, end - start + 1);
    }

    return maxLength;
  }
}

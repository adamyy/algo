package hashtables;

import java.util.HashMap;

/**
 * Given a string S and a string T, find the minimum window in S
 * which will contain all the characters in T in complexity O(n).
 * <p>
 * Example:
 * <p>
 * Input: S = "ADOBECODEBANC", T = "ABC"
 * Output: "BANC"
 * Note:
 * <p>
 * If there is no such window in S that covers all characters in T, return the empty string "".
 * If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
 */
public class MinimumWindowSubstring {
  public static String minWindow(String s, String t) {
    HashMap<Character, Integer> map = new HashMap<>();
    for (char ch : t.toCharArray()) map.put(ch, map.getOrDefault(ch, 0) + 1);

    int begin = 0, end = 0; // the sliding window

    int matches = 0;

    int head = 0; // the beginning of the substring
    int distance = Integer.MAX_VALUE; // the length of the substring

    while (end < s.length()) {
      // check end char for matches
      char endChar = s.charAt(end);
      if (map.containsKey(endChar)) {
        int oldCount = map.get(endChar);
        map.put(endChar, oldCount - 1);
        if (oldCount > 0) matches++;
      }
      end++;

      while (matches == t.length()) {
        // shorten the string if we can
        if (end - begin < distance) {
          distance = end - begin;
          head = begin;
        }
        // check begin char
        char beginChar = s.charAt(begin);
        if (map.containsKey(beginChar)) {
          int oldCount = map.get(beginChar);
          map.put(beginChar, oldCount + 1);
          if (oldCount == 0) matches--;
        }
        begin++;
      }
    }

    return distance == Integer.MAX_VALUE ? "" : s.substring(head, head + distance);
  }
}

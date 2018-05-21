package hashtables;

import java.util.*;

/**
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 *
 * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
 *
 * The order of output does not matter.
 *
 * Example 1:
 *
 * Input:
 * s: "cbaebabacd" p: "abc"
 *
 * Output:
 * [0, 6]
 *
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * Example 2:
 *
 * Input:
 * s: "abab" p: "ab"
 *
 * Output:
 * [0, 1, 2]
 *
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 */
public class FindAllAnagramsInString {
  public static List<Integer> findAnagrams(String s, String anagram) {
    List<Integer> result = new ArrayList<>();
    if (s == null || anagram == null || s.length() < anagram.length()) return result;

    Map<Character, Integer> map = new HashMap<>();
    for (char c : anagram.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);

    int begin = 0, end = 0;
    int matches = 0;

    // sliding window
    while (end < s.length()) {
      char endChar = s.charAt(end);
      if (map.containsKey(endChar)) {
        int oldCount = map.get(endChar);
        int newCount = oldCount - 1;
        map.put(endChar, newCount);
        if (newCount == 0) matches++;
      }
      end++;

      if (matches == map.size()) result.add(begin);

      if (end - begin == anagram.length()) {
        char beginChar = s.charAt(begin);
        if (map.containsKey(beginChar)) {
          int oldCount = map.get(beginChar);
          int newCount = oldCount + 1;
          map.put(beginChar, newCount);
          if (oldCount == 0) matches--;
        }

        begin++;
      }
    }

    return result;
  }

  // wrong
  public static List<Integer> findAnagramsSimplified(String s, String p) {
    if (s == null || s.length() == 0) return Collections.EMPTY_LIST;
    if (p == null || p.length() == 0) return Collections.EMPTY_LIST;
    if (s.length() < p.length()) return Collections.EMPTY_LIST;

    List<Integer> result = new ArrayList<>();
    int target = 0;
    int[] map = new int['z' - 'a' + 1];
    for (char c : p.toCharArray()) {
      map[c - 'a'] = c;
      target += c;
    }

    int sum = 0;
    for (int index = 0; index < s.length(); index++) {
      if (index >= p.length()) sum -= map[s.charAt(index - p.length()) - 'a'];

      sum += map[s.charAt(index) - 'a'];

      if (sum == target) result.add(index - p.length() + 1);
    }

    return result;
  }

  public static List<Integer> findAnagramsSlidingWindow(String s, String p) {
    List<Integer> result = new ArrayList<>();
    if (s == null || s.length() == 0 || p == null || p.length() == 0) return result;

    Map<Character, Integer> map = new HashMap<>();
    for (char c : p.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);

    int begin = 0, end = 0, counter = map.size();

    while (end < s.length()) {
      char endChar = s.charAt(end);
      if (map.containsKey(endChar)) {
        map.put(endChar, map.get(endChar) - 1);
        if (map.get(endChar) == 0) counter--; // matched one char
      }

      while (counter == 0) {
        if (end - begin + 1 == p.length()) result.add(begin);
        char beginChar = s.charAt(begin);
        if (map.containsKey(beginChar)) {
          map.put(beginChar, map.get(beginChar) + 1);
          if (map.get(beginChar) > 0) counter++;
        }
        begin++;
      }

      end++;
    }

    return result;
  }
}

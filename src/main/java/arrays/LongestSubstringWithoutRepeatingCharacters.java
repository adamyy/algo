package arrays;

import java.util.HashMap;
import java.util.Map;

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

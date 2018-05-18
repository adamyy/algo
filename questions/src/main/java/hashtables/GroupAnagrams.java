package hashtables;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Given an array of strings, group anagrams together.
 *
 * Example:
 *
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * Note:
 *
 * All inputs will be in lowercase.
 * The order of your output does not matter.
 */
public class GroupAnagrams {
  public static List<List<String>> groupAnagrams(String[] strs) {
    List<List<String>> result = new ArrayList<>();
    HashMap<String, List<String>> map = new HashMap<>();
    if (strs == null || strs.length == 0) return result;

    for (String s : strs) {
      String encoded = encode(s);
      if (!map.containsKey(encoded)) map.put(encoded, new ArrayList<>());
      map.get(encoded).add(s);
    }

    result.addAll(map.values());

    return result;
  }

  private static String encode(String str) {
    int[] freq = new int[256]; // assume ascii
    for (int i = 0; i < str.length(); i++) freq[str.charAt(i) - 'a']++;
    return Arrays.toString(freq);
  }
}

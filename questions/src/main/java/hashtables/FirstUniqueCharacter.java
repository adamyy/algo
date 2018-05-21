package hashtables;

/**
 * Given a string, find the first non-repeating character in it and return it's index.
 * If it doesn't exist, return -1.
 * <p>
 * Examples:
 * <p>
 * s = "leetcode"
 * return 0.
 * <p>
 * s = "loveleetcode",
 * return 2.
 * Note: You may assume the string contain only lowercase letters.
 */
public class FirstUniqueCharacter {
  public static int firstUniqueCharacter(String s) {
    int[] hash = new int['z' - 'a' + 1];
    for (int i = 0; i < s.length(); i++) hash[s.charAt(i) - 'a']++;
    for (int i = 0; i < s.length(); i++) if (hash[s.charAt(i) - 'a'] == 1) return i;
    return -1;
  }
}

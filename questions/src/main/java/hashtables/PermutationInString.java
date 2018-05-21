package hashtables;

/**
 * Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1.
 * In other words, one of the first string's permutations is the substring of the second string.
 *
 * Example 1:
 * Input:s1 = "ab" s2 = "eidbaooo"
 * Output:True
 * Explanation: s2 contains one permutation of s1 ("ba").
 *
 * Example 2:
 * Input:s1= "ab" s2 = "eidboaoo"
 * Output: False
 *
 * Note:
 * The input strings only contain lower case letters.
 * The length of both given strings is in range [1, 10,000].
 */
public class PermutationInString {
  public static boolean checkInclusion(String shorter, String longer) {
    if (longer == null || longer.length() == 0) return false;
    if (shorter == null || shorter.length() == 0) return true;

    int[] map = new int['z' - 'a' + 1];
    int targetSum = 0;
    for (char c : shorter.toCharArray()) {
      map[c - 'a'] = c;
      targetSum += c;
    }

    int sum = 0;
    for (int index = 0; index < longer.length(); index++) {
      if (index >= shorter.length()) sum -= map[longer.charAt(index - shorter.length()) - 'a'];

      sum += map[longer.charAt(index) - 'a'];

      if (sum == targetSum) return true;
    }

    return false;
  }
}

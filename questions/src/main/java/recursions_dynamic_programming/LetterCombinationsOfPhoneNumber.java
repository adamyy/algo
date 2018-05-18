package recursions_dynamic_programming;

import java.util.*;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * Note that 1 does not map to any letters.
 *
 * Example:
 *
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class LetterCombinationsOfPhoneNumber {
  static final Map<Character, List<String>> DIGIT_MAP;
  static {
    Map<Character, List<String>> aMap = new HashMap<>();
    aMap.put('2', Arrays.asList("a","b","c"));
    aMap.put('3', Arrays.asList("d","e","f"));
    aMap.put('4', Arrays.asList("g","h","i"));
    aMap.put('5', Arrays.asList("j","k","l"));
    aMap.put('6', Arrays.asList("m","n","o"));
    aMap.put('7', Arrays.asList("p","q","r","s"));
    aMap.put('8', Arrays.asList("t","u","v"));
    aMap.put('9', Arrays.asList("w","x","y","z"));
    DIGIT_MAP = Collections.unmodifiableMap(aMap);
  }

  public List<String> letterCombinations(String digits) {
    List<String> result = new ArrayList<>();
    if (digits.length() == 0) return result;
    char[] arr = digits.toCharArray();
    backtrack(0, arr, new StringBuilder(), result);
    return result;
  }

  private void backtrack(int index, char[] arr, StringBuilder prefix, List<String> result) {
    if(index == arr.length) {
      result.add(prefix.toString());
      return;
    }

    for (String s: DIGIT_MAP.get(arr[index])) {
      backtrack(index + 1, arr, prefix.append(s), result);
      prefix.setLength(prefix.length() - 1);
    }
  }
}

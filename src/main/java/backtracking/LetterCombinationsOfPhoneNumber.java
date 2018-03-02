package backtracking;

import java.util.*;

interface Solution {
  List<String> letterCombinations(String digits);
}

public class LetterCombinationsOfPhoneNumber implements Solution {
  static final Map<Character, LinkedList<String>> DIGIT_MAP;
  static {
    Map<Character, LinkedList<String>> aMap = new HashMap<>();
    aMap.put('2', new LinkedList<>(Arrays.asList("a","b","c")));
    aMap.put('3', new LinkedList<>(Arrays.asList("d","e","f")));
    aMap.put('4', new LinkedList<>(Arrays.asList("g","h","i")));
    aMap.put('5', new LinkedList<>(Arrays.asList("j","k","l")));
    aMap.put('6', new LinkedList<>(Arrays.asList("m","n","o")));
    aMap.put('7', new LinkedList<>(Arrays.asList("p","q","r","s")));
    aMap.put('8', new LinkedList<>(Arrays.asList("t","u","v")));
    aMap.put('9', new LinkedList<>(Arrays.asList("w","x","y","z")));
    DIGIT_MAP = Collections.unmodifiableMap(aMap);
  }

  @Override
  public List<String> letterCombinations(String digits) {
    return null;
  }
}

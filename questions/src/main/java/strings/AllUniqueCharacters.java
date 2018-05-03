package strings;

import java.util.BitSet;

public class AllUniqueCharacters {
  public static boolean isUnique(String str) {
    BitSet checker = new BitSet();
    for (int index = 0; index < str.length(); index++) {
      if (checker.get(str.charAt(index))) return false;
      checker.set(str.charAt(index));
    }
    return true;
  }
}

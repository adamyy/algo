package strings;

/**
 * There are three types of edits that can be performed on strings:
 *    insert a character,
 *    remove a character,
 *    or replace a character.
 * Given two strings, write a function to check if they are one edit (or zero edits) away.
 *
 * EXAMPLE
 * pale, ple -> true
 * pales, pale -> true
 * pale, bale -> true
 * pale, bake -> false
 */
public class OneAway {
  public static boolean oneAway(String first, String second) {
    if (first.length() == second.length()) {
      return oneEditAway(first, second);
    } else if (first.length() + 1 == second.length()) {
      return oneInsertAway(first, second);
    } else if (first.length() - 1 == second.length()) {
      return oneInsertAway(second, first);
    } else {
      return false;
    }
  }

  private static boolean oneEditAway(String first, String second) {
    boolean foundDifference = false;
    for (int i = 0; i < first.length(); i++) {
      if (first.charAt(i) != second.charAt(i)) {
        if (foundDifference) return false;
        foundDifference = true;
      }
    }
    return true;
  }

  private static boolean oneInsertAway(String shorter, String longer) {
    int indexShorter = 0;
    int indexLonger = 0;
    while (indexShorter < shorter.length() && indexLonger < longer.length()) {
      if (shorter.charAt(indexShorter) == longer.charAt(indexLonger)) {
        indexShorter++;
        indexLonger++;
      } else {
        if (indexShorter != indexLonger) { // if difference was already found once
          return false;
        }
        indexLonger++;
      }
    }
    return true;
  }
}

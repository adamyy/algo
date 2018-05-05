package strings;

/**
 * Implement a method to perform basic string compression using the counts of repeated characters.
 * For example, the string aabcccccaaa would become a2blc5a3.
 * If the "compressed" string would not become smaller than the original string, your method should return
 * the original string. You can assume the string has only uppercase and lowercase letters (a - z).
 */
public class StringCompression {
  public static String stringCompression(String str) {
    if (str.length() < 2) return str;

    StringBuilder result = new StringBuilder();

    char currentCharacter = str.charAt(0);
    int occurrence = 1;

    for (int index = 1; index < str.length(); index++) {
      if (str.charAt(index) != currentCharacter) {
        // flush the current character
        result.append(currentCharacter).append(occurrence);
        // update the current character
        currentCharacter = str.charAt(index);
        occurrence = 1;
      } else {
        occurrence++;
      }
    }

    // flush the last character
    result.append(currentCharacter).append(occurrence);

    if (result.length() < str.length()) {
      return result.toString();
    } else {
      return str;
    }
  }
}

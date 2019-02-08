package maths;

/**
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 *
 * For example:
 *
 *     1 -> A
 *     2 -> B
 *     3 -> C
 *     ...
 *     26 -> Z
 *     27 -> AA
 *     28 -> AB
 *     ...
 * Example 1:
 *
 * Input: 1
 * Output: "A"
 * Example 2:
 *
 * Input: 28
 * Output: "AB"
 * Example 3:
 *
 * Input: 701
 * Output: "ZY"
 */
public class ExcelSheetColumnTitle {
  public static String convertToTitle(int n) {
    // convert to base 26
    StringBuilder res = new StringBuilder();
    while (n > 0) {
      res.append((char)('A' + (n - 1) % 26));
      n = (n - 1) / 26;
    }
    return res.reverse().toString();
  }
}

package daily_challenge;

import java.util.Arrays;

/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping way:
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Beyond that, now the encoded string can also contain the character '*', which can be treated as one of the numbers from 1 to 9.
 * <p>
 * Given the encoded message containing digits and the character '*', return the total number of ways to decode it.
 * <p>
 * Also, since the answer may be very large, you should return the output mod 109 + 7.
 * <p>
 * Example 1:
 * Input: "*"
 * Output: 9
 * Explanation: The encoded message can be decoded to the string: "A", "B", "C", "D", "E", "F", "G", "H", "I".
 * <p>
 * Example 2:
 * Input: "1*"
 * Output: 9 + 9 = 18
 * <p>
 * Note:
 * The length of the input string will fit in range [1, 10^5].
 * The input string will only contain the character '*' and digits '0' - '9'.
 */
public class DecodeStringII {
  public static int decode(String s) {
    if (s.charAt(0) == '0') return 0;

    long[] dp = new long[s.length() + 1];
    dp[0] = 1;
    dp[1] = (s.charAt(0) == '*') ? 9 : 1;

    for (int i = 2; i <= s.length(); i++) {
      char first = s.charAt(i - 2);
      char second = s.charAt(i - 1);
      long decodeOne = decodeOneFactor(second) * dp[i - 1];
      long decodeTwo = decodeTwoFactor(first, second) * dp[i - 2];
      dp[i] = (decodeOne + decodeTwo) % 1000000007;
    }

    return (int) dp[s.length()];
  }

  private static int decodeOneFactor(char c) {
    if (c == '*') return 9;
    if (c > '0') return 1;
    return 0;
  }

  private static int decodeTwoFactor(char first, char second) {
    if (first == '*') {
      if (second == '*') return 15; // **
      if (second <= '6') return 2; // *n
      return 1;
    }

    if (second == '*') { // n*
      if (first == '1') return 9; // 1*
      if (first == '2') return 6; // 2*
      return 0;
    }

    return first == '1' || (first == '2' && second <= '6') ? 1 : 0; // nn
  }
}

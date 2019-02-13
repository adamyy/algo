package daily_challenge;

import tags.Recursions;

import java.util.Arrays;

/**
 * Given the mapping a = 1, b = 2, ... z = 26, and an encoded message, count the number of ways it can be decoded.
 * <p>
 * For example, the message '111' would give 3, since it could be decoded as 'aaa', 'ka', and 'ak'.
 * <p>
 * You can assume that the messages are decodeable. For example, '001' is not allowed.
 */
public class DecodeString {
  @Recursions
  public static int decode(String message) {
    if (message.startsWith("0")) return 0;
    int[] dp = new int[message.length()];
    Arrays.fill(dp, -1);
    return decodeHelper(message, 0, dp);
  }

  // at each step, either 1 digit can be decoded, or 2 digits
  // decode(message) = decode(message - 1 digit) + decode(message - 2 digits)
  private static int decodeHelper(String message, int start, int[] dp) {
    if (message.length() == start) return 1; // we exhausted the message
    if (message.charAt(start) == '0') return 0; // we cannot decode this message
    if (dp[start] != -1) return dp[start]; // cache hit
    int decodeOne = decodeHelper(message, start + 1, dp);
    int decodeTwo = start + 1 < message.length() && Integer.parseInt(message.substring(start, start + 2)) <= 26 ? decodeHelper(message, start + 2, dp) : 0;
    dp[start] = decodeOne + decodeTwo;
    return dp[start];
  }
}

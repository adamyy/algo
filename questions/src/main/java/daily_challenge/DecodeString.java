package daily_challenge;

import tags.Recursions;

/**
 * Given the mapping a = 1, b = 2, ... z = 26, and an encoded message, count the number of ways it can be decoded.
 *
 * For example, the message '111' would give 3, since it could be decoded as 'aaa', 'ka', and 'ak'.
 *
 * You can assume that the messages are decodeable. For example, '001' is not allowed.
 */
public class DecodeString {
  @Recursions
  public static int decode(String message) {
    return decodeHelper(message, 0);
  }

  private static int decodeHelper(String message, int start) {
    // at each step, either 1 digit can be decoded, or 2 digits
    // decode(message) = decode(message - 1 digit) + decode(message - 2 digits)
    if (start > message.length()) return 0;
    if (start == message.length()) return 1; // we exhausted the message
    if (message.length() - start == 1) return 1; // any 1 digit can be decoded
    int decodeOne = decodeHelper(message, start + 1);
    int decodeTwo = decodeable(message, start, start + 1) ? decodeHelper(message, start + 2) : 0;
    return decodeOne + decodeTwo;
  }

  private static boolean decodeable(String message, int start, int end) {
    return message.charAt(start) <= '2' && end < message.length() && message.charAt(end) <= '6';
  }
}

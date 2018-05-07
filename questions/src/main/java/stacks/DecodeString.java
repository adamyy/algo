package stacks;

import java.util.Stack;

/**
 * Given an encoded string, return it's decoded string.
 *
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times.
 * Note that k is guaranteed to be a positive integer.
 *
 * You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
 *
 * Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k.
 * For example, there won't be input like 3a or 2[4].
 *
 * Examples:
 *
 * s = "3[a]2[bc]", return "aaabcbc".
 * s = "3[a2[c]]", return "accaccacc".
 * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 */
public class DecodeString {
  public static String decodeString(String s) {
    Stack<Integer> count = new Stack<>();
    Stack<String> result = new Stack<>();

    int index = 0;
    result.push("");

    while (index < s.length()) {
      char ch = s.charAt(index);
      if (Character.isDigit(ch)) {
        // parse number
        int start = index;
        while (Character.isDigit(s.charAt(index + 1))) index++;
        count.push(Integer.parseInt(s.substring(start, index + 1)));
      } else if (ch == '[') {
        // ignore left bracket in current result
        result.push("");
      } else if (ch == ']') {
        // decode string and append it to last result
        String currentStr = result.pop();
        int times = count.pop();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < times; i++) {
          builder.append(currentStr);
        }
        result.push(result.pop() + builder.toString());
      } else {
        // append current character to current result
        result.push(result.pop() + ch);
      }
      index++;
    }

    return result.pop();
  }
}

package stacks;

import java.util.Stack;

/**
 * Implement a basic calculator to evaluate a simple expression string.
 *
 * The expression string may contain open ( and closing parentheses ),
 * the plus + or minus sign -, non-negative integers and empty spaces .
 *
 * Example 1:
 *
 * Input: "1 + 1"
 * Output: 2
 * Example 2:
 *
 * Input: " 2-1 + 2 "
 * Output: 3
 * Example 3:
 *
 * Input: "(1+(4+5+2)-3)+(6+8)"
 * Output: 23
 */
public class CalculatorWithBrackets {
  public static int calculate(String s) {
    if (s == null || s.length() == 0) return 0;
    Stack<Character> ops = new Stack<>();
    Stack<Integer> values = new Stack<>();
    char[] tokens = s.toCharArray();

    for (int i = 0; i < s.length(); i++) {
      if (tokens[i] == ' ') continue;
      if (isDigit(tokens[i])) {
        // parse number
        StringBuilder builder = new StringBuilder();
        while (i < s.length() && isDigit(tokens[i])) {
          builder.append(tokens[i++]);
        }
        values.push(Integer.parseInt(builder.toString()));
        i--;
      } else if (isOperator(tokens[i])) {
        while (!ops.empty() && !isBrackets(ops.peek()) && hasPrecedence(ops.peek(), tokens[i])) {
          values.push(applyOperation(values.pop(), values.pop(), ops.pop()));
        }
        ops.push(tokens[i]);
      } else if (tokens[i] == '(') {
        ops.push(tokens[i]);
      } else if (tokens[i] == ')') {
        while (ops.peek() != '(') {
          values.push(applyOperation(values.pop(), values.pop(), ops.pop()));
        }
        ops.pop();
      } else {
        throw new IllegalArgumentException();
      }
    }

    while (!ops.empty()) {
      values.push(applyOperation(values.pop(), values.pop(), ops.pop()));
    }

    return values.pop();
  }

  private static int applyOperation(int y, int x, char op) {
    if (op == '+') return x + y;
    if (op == '-') return x - y;
    if (op == '*') return x * y;
    if (op == '/') {
      if (y == 0) throw new UnsupportedOperationException();
      return x / y;
    }
    throw new IllegalArgumentException();
  }

  private static boolean hasPrecedence(char higher, char lower) {
    if ((lower == '*' || lower == '/') && (higher == '+' || higher == '-')) return false;
    return true;
  }

  private static boolean isBrackets(char ch) {
    return ch == '(' || ch == ')';
  }

  private static boolean isDigit(char ch) {
    return Character.isDigit(ch);
  }

  private static boolean isOperator(char ch) {
    return ch == '+' || ch == '-' || ch == '/' || ch == '*';
  }
}

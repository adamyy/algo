package stacks;

import java.util.Stack;

/**
 * Implement a basic calculator to evaluate a simple expression string.
 * <p>
 * The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.
 * <p>
 * Example 1:
 * <p>
 * Input: "3+2*2"
 * Output: 7
 * Example 2:
 * <p>
 * Input: " 3/2 "
 * Output: 1
 * Example 3:
 * <p>
 * Input: " 3+5 / 2 "
 * Output: 5
 */
public class Calculator {
  public static int calculate(String s) {
    char[] tokens = s.toCharArray();
    Stack<Character> operators = new Stack<>();
    Stack<Integer> values = new Stack<>();

    for (int i = 0; i < s.length(); i++) {
      if (tokens[i] == ' ') continue;
      if (Character.isDigit(tokens[i])) {
        StringBuilder builder = new StringBuilder();
        while (i < s.length() && isDigit(tokens[i])) {
          builder.append(tokens[i++]);
        }
        values.push(Integer.parseInt(builder.toString()));
        i--;
      } else if (isOperator(tokens[i])) {
        // While top of 'ops' has same or greater precedence to current
        // token, which is an operator. Apply operator on top of 'ops'
        // to top two elements in values stack
        while (!operators.empty() && hasPrecedence(operators.peek(), tokens[i])) {
          values.push(applyOperation(values.pop(), values.pop(), operators.pop()));
        }
        operators.push(tokens[i]);
      } else {
        throw new IllegalArgumentException();
      }
    }

    while (!operators.empty()) {
      values.push(applyOperation(values.pop(), values.pop(), operators.pop()));
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

  private static boolean isDigit(char ch) {
    return Character.isDigit(ch);
  }

  private static boolean isOperator(char ch) {
    return ch == '+' || ch == '-' || ch == '/' || ch == '*';
  }
}

package stacks;

import java.util.Stack;

interface Solution {
  boolean isValid(String s);
}

// https://leetcode.com/problems/valid-parentheses/description/
public class ValidParentheses implements Solution {
  @Override
  public boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      switch (s.charAt(i)) {
        case '(':
          stack.push(')');
          break;
        case '{':
          stack.push('}');
          break;
        case '[':
          stack.push(']');
          break;
        case ')':
          if (stack.empty() || stack.pop() != ')') return false;
          break;
        case '}':
          if (stack.empty() || stack.pop() != '}') return false;
          break;
        case ']':
          if (stack.empty() || stack.pop() != ']') return false;
          break;
        default:
          return false;
      }
    }
    return stack.empty();
  }
}

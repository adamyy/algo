package linkedlists;

import lib.ListNode;

import java.util.Stack;

/**
 * Implement a function to check if a linked list is a palindrome.
 */
public class Palindrome {
  public static boolean palindromeWithBuffer(ListNode head) {
    ListNode fast = head;
    ListNode slow = head;
    Stack<Integer> stack = new Stack<>();

    while (fast != null && fast.next != null) {
      stack.push(slow.val);
      slow = slow.next;
      fast = fast.next.next;
    }

    // has odd number of elements
    if (fast != null) slow = slow.next;

    while (slow != null) {
      int top = stack.pop();

      if (slow.val != top) {
        return false;
      }

      slow = slow.next;
    }

    return true;
  }

  static class Result {
    ListNode node;
    boolean result;
    Result(ListNode node, boolean result) {
      this.node = node;
      this.result = result;
    }
  }

  public static boolean palindromeNoBuffer(ListNode head) {
    int length = length(head);
    return palindromeNoBufferRecurse(head, length).result;
  }

  private static int length(ListNode node) {
    if (node == null) return 0;
    return 1 + length(node.next);
  }

  private static Result palindromeNoBufferRecurse(ListNode head, int length) {
    if (head == null || length <= 0) { // even number of nodes
      return new Result(head, true);
    } else if (length == 1) { // skip the middle node
      return new Result(head.next, true);
    }
    
    Result res = palindromeNoBufferRecurse(head.next, length - 2);
    
    // if child calls are not a palindrome, pass up the failure
    if (!res.result || res.node == null) return res;

    res.result = (head.val == res.node.val);

    res.node = res.node.next;

    return res;
  }

  public static boolean isPalindromeSimplified(ListNode head) {
    return head == null || isPalindromeRecursive(head, head) != null;
  }

  private static ListNode isPalindromeRecursive(ListNode node, ListNode head) {
    if (node == null) return head;
    ListNode result = isPalindromeRecursive(node.next, head);
    if (result == null) return null;
    if (result.val != node.val) return null;
    if (result.next != null) return result.next;
    return result;
  }
}

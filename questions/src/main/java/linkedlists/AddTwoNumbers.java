package linkedlists;

import lib.ListNode;

/**
 * You have two numbers represented by a linked list, where each node contains a single digit.
 * The digits are stored in reverse order, such that the 1 's digit is at the head of the list.
 * Write a function that adds the two numbers and returns the sum as a linked list.
 */
public class AddTwoNumbers {
  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode result = new ListNode(0);
    ListNode head = result;
    int sum = 0;

    while (l1 != null || l2 != null) {
      if (l1 != null) {
        sum += l1.val;
        l1 = l1.next;
      }
      if (l2 != null) {
        sum += l2.val;
        l2 = l2.next;
      }
      head.next = new ListNode(sum % 10);
      head = head.next;
      sum /= 10;
    }

    if (sum != 0) {
      head.next = new ListNode(sum);
    }

    return result.next;
  }

  static class PartialSum {
    ListNode node;
    int carry;
  }

  /**
   * Suppose the digits are stored in forward order. Repeat the above problem.
   */
  public static ListNode addTwoNumbersReversed(ListNode l1, ListNode l2) {
    // get the length of each linked list
    int len1 = length(l1);
    int len2 = length(l2);
    // pad the shorter list
    if (len1 > len2) {
      l2 = padList(l2, len1 - len2);
    } else {
      l1 = padList(l1, len2 - len1);
    }
    PartialSum sum = sumList(l1, l2);
    if (sum.carry == 0) {
      return sum.node;
    } else {
      return insertBefore(sum.node, sum.carry);
    }
  }

  private static PartialSum sumList(ListNode first, ListNode second) {
    if (first == null && second == null) return new PartialSum();

    PartialSum sum = sumList(first.next, second.next);

    int val = sum.carry + first.val + second.val;
    sum.node = insertBefore(sum.node, val % 10);
    sum.carry = val / 10;
    return sum;
  }

  private static int length(ListNode node) {
    if (node == null) return 0;
    return 1 + length(node.next);
  }

  private static ListNode padList(ListNode node, int padding) {
    if (padding == 0) return node;
    ListNode head = node;
    for (int i = 0; i < padding; i++) {
      head = insertBefore(head, 0);
    }
    return head;
  }

  private static ListNode insertBefore(ListNode node, int val) {
    ListNode newNode = new ListNode(val);
    if (node != null) {
      newNode.next = node;
    }
    return newNode;
  }
}

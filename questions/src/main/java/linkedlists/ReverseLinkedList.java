package linkedlists;

import lib.ListNode;

/**
 * Reverse a singly linked list.
 *
 * Example:
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 *
 * Follow up:
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 */
public class ReverseLinkedList {
  public static ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode next = head.next;
    head.next = null;
    return reverseList(head, next);
  }

  private static ListNode reverseList(ListNode prev, ListNode curr) {
    if (curr == null) return prev;
    ListNode next = curr.next;
    curr.next = prev;
    return reverseList(curr, next);
  }
}

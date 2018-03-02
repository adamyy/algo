package linkedlists;

import lib.ListNode;

interface Solution {
  ListNode removeNthFromEnd(ListNode head, int n);
}

// https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
// Given a linked list, remove the nth node from the end of list and return its head.
public class RemoveNthNodeFromEnd implements Solution {
  @Override
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode fast = head;
    ListNode slow = head;

    while (n-- > 0) fast = fast.next;

    if (fast == null) return head.next;

    while (fast.next != null) {
      fast = fast.next;
      slow = slow.next;
    }

    slow.next = slow.next.next;

    return head;
  }
}

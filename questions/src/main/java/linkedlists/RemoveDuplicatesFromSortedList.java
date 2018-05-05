package linkedlists;

import lib.ListNode;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 *
 * Example 1:
 * Input: 1->1->2
 * Output: 1->2
 *
 * Example 2:
 * Input: 1->1->2->3->3
 * Output: 1->2->3
 */
public class RemoveDuplicatesFromSortedList {
  public static ListNode deleteDuplicates(ListNode node) {
    ListNode head = node;

    while (head != null) {
      int curr = head.val;

      while (head.next != null) {
        ListNode next = head.next;
        if (next.val != curr) break;
        else head.next = next.next;
      }

      head = head.next;
    }

    return node;
  }
}

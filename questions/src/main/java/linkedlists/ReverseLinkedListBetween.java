package linkedlists;

import lib.ListNode;

/**
 * Reverse a linked list from position m to n. Do it in one-pass.
 *
 * Note: 1 ≤ m ≤ n ≤ length of list.
 *
 * Example:
 *
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
 *
 * Input: 1->2->3->4->5->NULL, m = 1, n = 5
 * Output: 5->4->3->2->1->NULL
 */
public class ReverseLinkedListBetween {
  public static ListNode reverseBetween(ListNode head, int m, int n) {
    if (head == null || head.next == null) return head;

    ListNode phantom = new ListNode(0);
    phantom.next = head;

    ListNode prev = phantom;

    for (int i = 0; i < m - 1; i++) prev = prev.next;

    ListNode curr = prev.next;
    ListNode next = curr.next;

    for (int i = 0; i < n - m; i++) {
      System.out.println("prev: " + prev.val + ", curr: " + curr.val + ", next: " + next.val);
      curr.next = next.next;
      next.next = prev.next;
      prev.next = next;
      next = curr.next;
    }

    return phantom.next;
  }
}

package linkedlists;

import lib.ListNode;

/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 * <p>
 * Example 1:
 * <p>
 * Input: 1->2->3->3->4->4->5
 * Output: 1->2->5
 * <p>
 * Example 2:
 * <p>
 * Input: 1->1->1->2->3
 * Output: 2->3
 */
public class RemoveDuplicatedElements {
  public static ListNode deleteDuplicates(ListNode node) {
    ListNode curr = node;
    ListNode phantom = new ListNode(0, curr);
    ListNode prev = phantom;

    while (curr != null) {
      int currVal = curr.val;
      boolean deleteCurr = false;

      while (curr.next != null) {
        ListNode next = curr.next;
        if (next.val != currVal) break;
        curr.next = next.next;
        deleteCurr = true;
      }

      if (deleteCurr) {
        prev.next = curr.next;
      } else {
        prev = curr;
      }
      curr = curr.next;
    }

    return phantom.next;
  }
}

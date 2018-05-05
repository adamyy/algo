package linkedlists;

import lib.ListNode;

/**
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 */
public class MergeTwoSortedList {
  public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode head = new ListNode(0);
    ListNode phantom = head;

    while (l1 != null || l2 != null) {
      if (l1 != null && l2 != null) {
        if (l1.val < l2.val) {
          head.next = l1;
          l1 = l1.next;
        } else {
          head.next = l2;
          l2 = l2.next;
        }
        head = head.next;
      } else if (l1 == null) {
        head.next = l2;
        break;
      } else {
        head.next = l1;
        break;
      }
    }

    return phantom.next;
  }
}

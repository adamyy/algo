package linkedlists;

import lib.ListNode;

/**
 * Given a circular linked list, implement an algorithm that returns the node at the beginning of the loop.
 *
 * DEFINITION
 * Circular linked list: A (corrupt) linked list in which a node's next pointer points to an earlier node,
 * so as to make a loop in the linked list.
 *
 * EXAMPLE
 * Input: A -> B -> C -> D -> E -> C [the same C as earlier]
 * Output: C
 */
public class LoopDetection {
  public static ListNode loopStart(ListNode head) {
    // detect if the linked list has a loop
    ListNode slow = head;
    ListNode fast = head;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) break;
    }

    // figure out where the loop starts
    if (fast == null || fast.next == null) return null;

    slow = head;

    while (slow != fast) {
      slow = slow.next;
      fast = fast.next;
    }

    return slow;
  }
}

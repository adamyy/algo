package linkedlists;

import lib.ListNode;

/**
 * Given a linked list, rotate the list to the right by k places, where k is non-negative.
 *
 * Example 1:
 *
 * Input: 1->2->3->4->5->NULL, k = 2
 * Output: 4->5->1->2->3->NULL
 *
 * Explanation:
 *
 * rotate 1 steps to the right: 5->1->2->3->4->NULL
 * rotate 2 steps to the right: 4->5->1->2->3->NULL
 *
 *
 * Example 2:
 *
 * Input: 0->1->2->NULL, k = 4
 * Output: 2->0->1->NULL
 *
 * Explanation:
 *
 * rotate 1 steps to the right: 2->0->1->NULL
 * rotate 2 steps to the right: 1->2->0->NULL
 * rotate 3 steps to the right: 0->1->2->NULL
 * rotate 4 steps to the right: 2->0->1->NULL
 */
public class RotateList {
  public static ListNode rotateRight(ListNode head, int k) {
    // cut the list once and reconnect the two parts
    int length = length(head);
    if (length == 0) return head;

    int partition = k % length;
    if (partition == 0) return head;

    ListNode slowRunner = head;
    ListNode fastRunner = head;

    for (int i = 0; i < partition; i++) fastRunner = fastRunner.next;

    while (true) {
      slowRunner = slowRunner.next;
      fastRunner = fastRunner.next;
      // reached the end
      if (fastRunner.next == null) break;
    }

    // now fastRunner is at the tail, where slowRunner is at the cutting location
    ListNode result = slowRunner.next;

    // cut the list
    slowRunner.next = null;
    fastRunner.next = head;

    return result;
  }

  private static int length(ListNode node) {
    if (node == null) return 0;
    return 1 + length(node.next);
  }
}

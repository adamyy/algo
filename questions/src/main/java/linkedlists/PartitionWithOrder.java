package linkedlists;

import lib.ListNode;

/**
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 *
 * You should preserve the original relative order of the nodes in each of the two partitions.
 *
 * Example:
 *
 * Input: head = 1->4->3->2->5->2, x = 3
 * Output: 1->2->2->4->3->5
 */
public class PartitionWithOrder {
  public static ListNode partition(ListNode node, int x) {
    ListNode phantomSmall = new ListNode(0);
    ListNode phantomLarge = new ListNode(0);
    ListNode currSmall = phantomSmall;
    ListNode currLarge = phantomLarge;

    while (node != null) {
      if (node.val < x) {
        currSmall.next = node;
        currSmall = node;
      } else {
        currLarge.next = node;
        currLarge = node;
      }
      node = node.next;
    }

    currSmall.next = phantomLarge.next;
    currLarge.next = null;
    return phantomSmall.next;
  }
}

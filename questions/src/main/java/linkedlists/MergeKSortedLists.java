package linkedlists;

import lib.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 */
public class MergeKSortedLists {
  public static ListNode mergeKLists(ListNode[] lists) {
    PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(l -> l.val));
    ListNode head = new ListNode(0);
    ListNode phantom = head;
    for (ListNode node: lists) {
      if (node != null) {
        priorityQueue.offer(node);
      }
    }
    while(!priorityQueue.isEmpty()) {
      head.next = priorityQueue.poll();
      head = head.next;
      if (head.next != null) priorityQueue.offer(head.next);
    }

    return phantom.next;
  }
}

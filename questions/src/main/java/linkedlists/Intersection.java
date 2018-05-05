package linkedlists;

import lib.ListNode;

/**
 * Given two (singly) linked lists, determine if the two lists intersect.
 * Return the inter­secting node.
 * Note that the intersection is de ned based on reference, not value.
 * That is, if the kth node of the first linked list is the exact same node (by reference)
 * as the jth node of the second linked list, then they are intersecting.
 */
public class Intersection {
  public static boolean intersect(ListNode first, ListNode second) {
    if (first == null || second == null) return false;

    while (first.next != null) first = first.next;
    while (second.next != null) second = second.next;

    return first == second;
  }

  public static ListNode intersection(ListNode first, ListNode second) {
    int firstLength = length(first);
    int secondLength = length(second);

    if (firstLength == 0 || secondLength == 0) return null;

    if (firstLength > secondLength) {
      step(first, firstLength - secondLength);
    } else {
      step(second, secondLength - firstLength);
    }

    int length = Math.min(firstLength, secondLength);

    for (int i = 0; i < length; i++) {
      if (first == second) return first;
      first = first.next;
      second = second.next;
    }

    return null;
  }

  private static void step(ListNode node, int steps) {
    while (steps-- > 0) node = node.next;
  }

  private static int length(ListNode node) {
    if (node == null) return 0;
    return 1 + length(node.next);
  }
}

package linkedlists;

import lib.ListNode;

import java.util.HashSet;

public class RemoveDuplicates {
  public static ListNode removeDuplicatesWithBuffer(ListNode node) {
    ListNode head = node;
    HashSet<Integer> buffer = new HashSet<>();
    ListNode previous = null;
    while (node != null) {
      if (buffer.contains(node.val)) {
        previous.next = node.next;
      } else {
        buffer.add(node.val);
        previous = node;
      }
      node = node.next;
    }
    return head;
  }

  public static ListNode removeDuplicatesNoBuffer(ListNode node) {
    ListNode current = node;
    while (current != null) {
      ListNode runner = current;
      while (runner.next != null) {
        if (runner.next.val == current.val) {
          runner.next = runner.next.next;
        } else {
          runner = runner.next;
        }
      }
      current = current.next;
    }
    return node;
  }
}

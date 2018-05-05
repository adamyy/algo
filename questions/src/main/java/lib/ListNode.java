package lib;

import java.util.ArrayList;
import java.util.List;

public class ListNode {
  public int val;
  public ListNode next;

  public ListNode(int val) {
    this.val = val;
  }

  public ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }

  public static int[] toArray(ListNode node) {
    if (node == null) return new int[]{};
    List<Integer> result = new ArrayList<>();
    do {
      result.add(node.val);
      node = node.next;
    } while (node != null);
    // hacky but effective.
    return result.stream().mapToInt(Integer::intValue).toArray();
  }

  /**
   * Construct a linked list from an array and return the head
   * @param arr
   * @return head of the linked list
   */
  public static ListNode fromArray(int... arr) {
    if (arr.length == 0) return null;
    ListNode head = new ListNode(arr[0]);
    ListNode tail = head;
    for (int index = 1; index < arr.length; index++) {
      tail.next = new ListNode(arr[index]);
      tail = tail.next;
    }
    return head;
  }
}

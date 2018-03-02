package linkedlists;

import lib.ListNode;

public class AddTwoNumbers {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode result = new ListNode(0);
    ListNode head = result;
    int sum = 0;

    while (l1 != null || l2 != null) {
      if (l1 != null) {
        sum += l1.val;
        l1 = l1.next;
      }
      if (l2 != null) {
        sum += l2.val;
        l2 = l2.next;
      }
      head.next = new ListNode(sum % 10);
      head = head.next;
      sum /= 10;
    }

    if (sum != 0) {
      head.next = new ListNode(sum);
    }

    return result.next;
  }
}

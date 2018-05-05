package linkedlists;

import lib.ListNode;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class AddTwoNumbersTest {

  @Test
  public void addTwoNumbers() {
    ListNode first = ListNode.fromArray(new int[] { 7, 1, 6 });
    ListNode second = ListNode.fromArray(new int[] { 5, 9, 2 });
    assertThat(ListNode.toArray(AddTwoNumbers.addTwoNumbers(first, second)))
        .isEqualTo(new int[] { 2, 1, 9 });
  }

  @Test
  public void addTwoNumbersReversed() {
    ListNode first = ListNode.fromArray(new int[] { 6, 1, 7 });
    ListNode second = ListNode.fromArray(new int[] { 2, 9, 5 });
    assertThat(ListNode.toArray(AddTwoNumbers.addTwoNumbersReversed(first, second)))
        .isEqualTo(new int[] { 9, 1, 2 });
  }
}
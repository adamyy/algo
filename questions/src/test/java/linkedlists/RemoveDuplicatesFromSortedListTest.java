package linkedlists;

import lib.ListNode;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class RemoveDuplicatesFromSortedListTest {

  @Test
  public void deleteDuplicates() {
    assertThat(
        ListNode.toArray(RemoveDuplicatesFromSortedList.deleteDuplicates(ListNode.fromArray(1, 1, 2)))
    ).isEqualTo(new int[] { 1, 2 });

    assertThat(
        ListNode.toArray(RemoveDuplicatesFromSortedList.deleteDuplicates(ListNode.fromArray(1, 1, 2, 3, 3)))
    ).isEqualTo(new int[] { 1, 2, 3 });
  }
}
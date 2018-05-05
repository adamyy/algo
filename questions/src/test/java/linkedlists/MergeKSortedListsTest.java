package linkedlists;

import lib.ListNode;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class MergeKSortedListsTest {

  @Test
  public void mergeKLists() {
    ListNode[] arr = new ListNode[3];
    arr[0] = ListNode.fromArray(new int[]{1, 4, 5});
    arr[1] = ListNode.fromArray(new int[]{1, 3, 4});
    arr[2] = ListNode.fromArray(new int[]{2, 6});
    assertThat(ListNode.toArray(MergeKSortedLists.mergeKLists(arr)))
        .isEqualTo(new int[] { 1, 1, 2, 3, 4, 4, 5, 6 });
  }
}
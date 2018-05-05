package linkedlists;

import lib.ListNode;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class RemoveDuplicatesTest {

  @Test
  public void removeDuplicatesWithBuffer() {
    ListNode test = ListNode.fromArray(new int[] { 1,2,2,3,3,4,1,2,3,4 });
    assertThat(ListNode.toArray(RemoveDuplicates.removeDuplicatesWithBuffer(test)))
        .isEqualTo(new int[] { 1,2,3,4 });
  }

  @Test
  public void removeDuplicatesNoBuffer() {
    ListNode test = ListNode.fromArray(new int[] { 1,2,2,3,3,4,1,2,3,4 });
    assertThat(ListNode.toArray(RemoveDuplicates.removeDuplicatesNoBuffer(test)))
        .isEqualTo(new int[] { 1,2,3,4 });
  }
}
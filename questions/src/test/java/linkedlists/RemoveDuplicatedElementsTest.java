package linkedlists;

import lib.ListNode;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class RemoveDuplicatedElementsTest {

  @Test
  public void deleteDuplicates() {
    assertThat(ListNode.toArray(RemoveDuplicatedElements.deleteDuplicates(ListNode.fromArray(1, 2, 3, 3, 4, 4, 5)))).
        isEqualTo(new int[] { 1, 2 ,5 });
    assertThat(ListNode.toArray(RemoveDuplicatedElements.deleteDuplicates(ListNode.fromArray(1, 1, 1, 2, 3)))).
        isEqualTo(new int[] { 2, 3 });
  }
}
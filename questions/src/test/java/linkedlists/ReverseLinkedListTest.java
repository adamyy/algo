package linkedlists;

import lib.ListNode;
import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class ReverseLinkedListTest {

  @Test
  public void reverseList() {
    assertThat(ListNode.toArray(ReverseLinkedList.reverseList(ListNode.fromArray(1, 2, 3, 4, 5))))
        .isEqualTo(new int[] { 5, 4, 3, 2, 1 });
  }
}
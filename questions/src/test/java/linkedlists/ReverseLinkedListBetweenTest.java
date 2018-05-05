package linkedlists;

import lib.ListNode;
import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class ReverseLinkedListBetweenTest {

  @Test
  public void reverseBetween() {
//    ListNode list = ListNode.fromArray(1, 2, 3, 4, 5);
//    assertThat(ListNode.toArray(ReverseLinkedListBetween.reverseBetween(list, 2, 4)))
//        .isEqualTo(new int[] { 1, 4, 3, 2, 5 });
//    assertThat(ListNode.toArray(ReverseLinkedListBetween.reverseBetween(list, 1, 5)))
//        .isEqualTo(new int[] { 5, 4, 3, 2, 1 });
//    assertThat(ListNode.toArray(ReverseLinkedListBetween.reverseBetween(list, 1, 1)))
//        .isEqualTo(new int[] { 1, 2, 3, 4, 5 });

    assertThat(ListNode.toArray(ReverseLinkedListBetween.reverseBetween(ListNode.fromArray(1, 2, 3, 4, 5, 6), 2, 5)))
        .isEqualTo(new int[] { 1, 5, 4, 3, 2, 6 });
  }
}
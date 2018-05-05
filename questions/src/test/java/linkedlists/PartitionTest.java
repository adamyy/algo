package linkedlists;

import lib.ListNode;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class PartitionTest {

  @Test
  public void partition() {
    ListNode node = ListNode.fromArray(new int[] { 3, 5, 8, 5, 10, 2, 1 });
    assertThat(ListNode.toArray(Partition.partition(node, 5)))
        .isEqualTo(new int[] { 1, 2, 3, 5, 8, 5, 10 });
  }
}
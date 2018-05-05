package linkedlists;

import lib.ListNode;
import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class PartitionWithOrderTest {

  @Test
  public void partition() {
    assertThat(ListNode.toArray(PartitionWithOrder.partition(ListNode.fromArray(1,4,3,2,5,2), 3)))
        .isEqualTo(new int[] { 1,2,2,4,3,5 });
  }
}
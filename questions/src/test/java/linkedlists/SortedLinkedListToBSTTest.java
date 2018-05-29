package linkedlists;

import lib.ListNode;
import lib.TreeNode;
import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class SortedLinkedListToBSTTest {

  @Test
  public void sortedListToBST() {
    assertThat(SortedLinkedListToBST.sortedListToBSTInOrder(ListNode.fromArray(-10, -3, 0, 5, 9)))
        .isEqualTo(TreeNode.buildTreeFromArray(0, -10, 5, null, -3, null, 9));
  }
}
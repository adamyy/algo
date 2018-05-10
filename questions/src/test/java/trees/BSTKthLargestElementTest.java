package trees;

import lib.TreeNode;
import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class BSTKthLargestElementTest {

  @Test
  public void kthSmallest() {
    TreeNode first = TreeNode.buildTreeFromArray(3, 1, 4, null, 2);
    assertThat(BSTKthLargestElement.kthSmallest(first, 1)).isEqualTo(1);

    TreeNode second = TreeNode.buildTreeFromArray(5, 3, 6, 2, 4, null, null, 1);
    assertThat(BSTKthLargestElement.kthSmallest(second, 3)).isEqualTo(3);
  }
}
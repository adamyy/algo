package trees;

import lib.TreeNode;
import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class BinaryTreeMaximumPathSumTest {

  @Test
  public void maxPathSum() {
    TreeNode normieTree = TreeNode.buildTreeFromArray(1, 2, 3);
    assertThat(BinaryTreeMaximumPathSum.maxPathSum(normieTree)).isEqualTo(6);

    TreeNode dankTree = TreeNode.buildTreeFromArray(-10, 9, 20, null, null, 15, 7);
    assertThat(BinaryTreeMaximumPathSum.maxPathSum(dankTree)).isEqualTo(42);
  }
}
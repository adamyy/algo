package trees;

import lib.TreeNode;
import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class DiameterOfBinaryTreeTest {

  @Test
  public void diameterOfBinaryTree() {
    TreeNode tree = TreeNode.buildTreeFromArray(1, 2, null, 4, 5, null, null, 6, null, 7);
    assertThat(DiameterOfBinaryTree.diameterOfBinaryTree(tree)).isEqualTo(4);
  }
}
package trees;

import lib.TreeNode;
import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class BuildTreeFromTraversalTest {

  @Test
  public void buildTree() {
    int[] preorder = {3, 9, 20, 15, 7};
    int[] inorder = {9, 3, 15, 20, 7};
    assertThat(BuildTreeFromTraversal.buildTree(preorder, inorder))
        .isEqualTo(TreeNode.buildTreeFromArray(3, 9, 20, null, null, 15, 7));
  }
}
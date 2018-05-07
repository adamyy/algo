package stacks;

import lib.TreeNode;
import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class BinaryTreePreorderTraversalTest {

  @Test
  public void preOrderTraversalRecursive() {
    TreeNode tree = TreeNode.buildTreeFromArray(1, null, 2, null, null, 3);
    assertThat(BinaryTreePreorderTraversal.preOrderTraversalRecursive(tree)).
        containsExactly(1, 2, 3);
  }

  @Test
  public void preOrderTraversal() {
    TreeNode tree = TreeNode.buildTreeFromArray(1, null, 2, null, null, 3);
    assertThat(BinaryTreePreorderTraversal.preOrderTraversal(tree)).
        containsExactly(1, 2, 3);
  }
}
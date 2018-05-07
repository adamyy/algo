package stacks;

import lib.TreeNode;
import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class BinaryTreeInorderTraversalTest {

  @Test
  public void inorderTraversal() {
    TreeNode tree = new TreeNode(1,
        null,
        new TreeNode(2,
            new TreeNode(3),
            null
        )
    );

    assertThat(BinaryTreeInorderTraversal.inorderTraversal(tree)).containsExactly(1, 3, 2);
  }
}
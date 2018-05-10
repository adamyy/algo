package trees;

import lib.TreeNode;
import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class CheckSubtreeTest {

  @Test
  public void isBinarySubtree() {
    TreeNode parent = TreeNode.buildTreeFromArray(3, 4, 5, 1, 2);
    TreeNode child = TreeNode.buildTreeFromArray(4, 1, 2);
    assertThat(CheckSubtree.isBinaryTreeSubtree(parent, child)).isTrue();

    TreeNode fakeParent = TreeNode.buildTreeFromArray(3, 4, 5, 1, 2, null, null, null, null, 0);
    assertThat(CheckSubtree.isBinaryTreeSubtree(fakeParent, child)).isFalse();
  }

  @Test
  public void isBSTSubtree() {
    TreeNode parent = TreeNode.buildTreeFromArray(2, 1, 3);
    TreeNode child = TreeNode.buildTreeFromArray(1);
    assertThat(CheckSubtree.isBSTSubtree(parent, child)).isTrue();
  }
}
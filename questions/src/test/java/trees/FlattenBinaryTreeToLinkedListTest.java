package trees;

import lib.TreeNode;
import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class FlattenBinaryTreeToLinkedListTest {

  @Test
  public void flatten() {
    TreeNode tree = TreeNode.buildTreeFromArray(1, 2, 5, 3, 4, null, 6);
    FlattenBinaryTreeToLinkedList.flatten(tree);
    assertThat(tree.val).isEqualTo(1); tree = tree.right;
    assertThat(tree.val).isEqualTo(2); tree = tree.right;
    assertThat(tree.val).isEqualTo(3); tree = tree.right;
    assertThat(tree.val).isEqualTo(4); tree = tree.right;
    assertThat(tree.val).isEqualTo(5); tree = tree.right;
    assertThat(tree.val).isEqualTo(6);
  }
}
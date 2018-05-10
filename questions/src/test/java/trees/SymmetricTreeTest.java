package trees;

import lib.TreeNode;
import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class SymmetricTreeTest {

  @Test
  public void isSymmetricRecursive() {
    TreeNode symmetric = TreeNode.buildTreeFromArray(1, 2, 2, 3, 4, 4, 3);
    assertThat(SymmetricTree.isSymmetricRecursive(symmetric)).isTrue();

    TreeNode asymmetric = TreeNode.buildTreeFromArray(1, 2, 2, null, 3, null, 3);
    assertThat(SymmetricTree.isSymmetricRecursive(asymmetric)).isFalse();
  }

  @Test
  public void isSymmetricIterative() {
    TreeNode symmetric = TreeNode.buildTreeFromArray(1, 2, 2, 3, 4, 4, 3);
    assertThat(SymmetricTree.isSymmetricIterative(symmetric)).isTrue();

    TreeNode asymmetric = TreeNode.buildTreeFromArray(1, 2, 2, null, 3, null, 3);
    assertThat(SymmetricTree.isSymmetricIterative(asymmetric)).isFalse();
  }
}
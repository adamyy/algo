package trees;

import lib.TreeNode;
import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class MinimalTreeTest {

  @Test
  public void createMinimalBST() {
    TreeNode result = MinimalTree.createMinimalBST(new int[] { 1,2,3,4,5,6,7 });

    assertThat(result.val).isEqualTo(4);
    assertThat(result.left.val).isEqualTo(2);
    assertThat(result.left.left.val).isEqualTo(1);
    assertThat(result.left.right.val).isEqualTo(3);
    assertThat(result.right.val).isEqualTo(6);
    assertThat(result.right.left.val).isEqualTo(5);
    assertThat(result.right.right.val).isEqualTo(7);
  }
}
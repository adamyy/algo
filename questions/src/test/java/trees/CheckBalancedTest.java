package trees;

import lib.TreeNode;
import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class CheckBalancedTest {

  @Test
  public void checkBalanced() {
    assertThat(CheckBalanced.isBalanced(TreeNode.buildTreeFromArray(
        1,
        2, 3
    ))).isTrue();

    assertThat(CheckBalanced.isBalanced(TreeNode.buildTreeFromArray(
       1,
       null, 2,
       null, null, 3
    ))).isFalse();
  }
}
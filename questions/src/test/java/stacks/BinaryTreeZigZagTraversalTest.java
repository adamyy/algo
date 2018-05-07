package stacks;

import lib.TreeNode;
import org.junit.Test;

import java.util.Arrays;

import static com.google.common.truth.Truth.*;

public class BinaryTreeZigZagTraversalTest {

  @Test
  public void zigzagLevelOrder() {
    TreeNode tree = TreeNode.buildTreeFromArray(3, 9, 20, null, null, 15, 7);
    assertThat(BinaryTreeZigZagTraversal.zigzagLevelOrder(tree)).containsExactly(
        Arrays.asList(3),
        Arrays.asList(20, 9),
        Arrays.asList(15, 7)
    );
  }
}
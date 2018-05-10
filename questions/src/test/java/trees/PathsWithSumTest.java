package trees;

import lib.TreeNode;
import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class PathsWithSumTest {

  @Test
  public void pathsWithSum() {
    TreeNode tree = TreeNode.buildTreeFromArray(10, 5, -3, 3, 2, null, 11, 3, -2, null, 1);
    assertThat(PathsWithSum.pathsWithSum(tree, 8)).isEqualTo(3);
  }
}
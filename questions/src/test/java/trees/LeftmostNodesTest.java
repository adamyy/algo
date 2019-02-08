package trees;

import lib.TreeNode;
import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class LeftmostNodesTest {

  @Test
  public void leftmostNodes() {
    assertThat(LeftmostNodes.leftmostNodes(new TreeNode(1))).containsExactly(1);
    assertThat(LeftmostNodes.leftmostNodes(
        new TreeNode(1,
            new TreeNode(2,
                new TreeNode(4,
                    new TreeNode(6),
                    null
                ),
                new TreeNode(5)
            ),
            new TreeNode(3)
        )
    )).containsExactly(1, 2, 4, 6);
    assertThat(LeftmostNodes.leftmostNodes(
        new TreeNode(1,
            null,
            new TreeNode(2,
                new TreeNode(3,
                    new TreeNode(4),
                    new TreeNode(5)
                ),
                null
            )
        )
    )).containsExactly(1, 2, 3, 4);
  }
}
package daily_challenge;

import lib.TreeNode;
import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class UnivalTreeTest {

  @Test
  public void count() {
    assertThat(UnivalTree.count(
        new TreeNode(
            0,
            new TreeNode(1),
            new TreeNode(
                0,
                new TreeNode(
                    1,
                    new TreeNode(1),
                    new TreeNode(1)
                ),
                new TreeNode(0)
            )
        )
    )).isEqualTo(5);
  }
}
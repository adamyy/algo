package trees;

import lib.TreeNode;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

import static com.google.common.truth.Truth.*;

public class BSTSequenceTest {

  @Test
  public void allSequences() {
    assertThat(BSTSequence.allSequences(TreeNode.buildTreeFromArray(2,1,3)))
        .containsExactly(
            new LinkedList<>(Arrays.asList(2, 1, 3)),
            new LinkedList<>(Arrays.asList(2, 3, 1))
        );
  }
}
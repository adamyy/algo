package stacks;

import lib.TreeNode;
import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class BSTIteratorTest {
  @Test
  public void test() {
    TreeNode tree = TreeNode.buildTreeFromArray(7, 3, 15, null, null, 9, 20);
    BSTIterator iterator = new BSTIterator(tree);
    assertThat(iterator.next()).isEqualTo(3);
    assertThat(iterator.next()).isEqualTo(7);
    assertThat(iterator.hasNext()).isTrue();
    assertThat(iterator.next()).isEqualTo(9);
    assertThat(iterator.hasNext()).isTrue();
    assertThat(iterator.next()).isEqualTo(15);
    assertThat(iterator.hasNext()).isTrue();
    assertThat(iterator.next()).isEqualTo(20);
    assertThat(iterator.hasNext()).isFalse();
  }
}
package graphs;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class MinimumHeightTreesTest {

  @Test
  public void minimumHeightTrees() {
    int[][] edges1 = {{1, 0}, {1, 2}, {1, 3}};
    assertThat(MinimumHeightTrees.minimumHeightTrees(4, edges1)).containsExactly(1);
    int[][] edges2 = {{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}};
    assertThat(MinimumHeightTrees.minimumHeightTrees(6, edges2)).containsExactly(3, 4);
  }
}
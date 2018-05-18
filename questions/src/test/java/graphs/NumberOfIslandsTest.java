package graphs;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class NumberOfIslandsTest {

  @Test
  public void numIslands() {
    char[][] oneIsland = new char[][]{
        new char[]{'1', '1', '1', '1', '0'},
        new char[]{'1', '1', '0', '1', '0'},
        new char[]{'1', '1', '0', '0', '0'},
        new char[]{'0', '0', '0', '0', '0'},
    };
    assertThat(NumberOfIslands.numIslands(oneIsland)).isEqualTo(1);

    char[][] threeIslands = new char[][]{
        new char[]{'1', '1', '0', '0', '0'},
        new char[]{'1', '1', '0', '0', '0'},
        new char[]{'0', '0', '1', '0', '0'},
        new char[]{'0', '0', '0', '1', '1'},
    };
    assertThat(NumberOfIslands.numIslands(threeIslands)).isEqualTo(3);
  }
}
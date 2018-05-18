package recursions_dynamic_programming;

import lib.Point;
import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class RobotInGridTest {

  @Test
  public void getPath() {
    boolean[][] maze = new boolean[][]{
        new boolean[]{true, false, true, true},  // [0, 0], [0, 1], [0, 2], [0, 3]
        new boolean[]{true, false, false, false}, // [1, 0], [1, 1], [1, 2], [1, 3]
        new boolean[]{true, true, true, true},  // [2, 0], [2, 1], [2, 2], [2, 3]
        new boolean[]{true, true, false, true}, // [3, 0], [3, 1], [3, 2], [3, 3]
    };

    assertThat(RobotInGrid.getPath(maze))
        .containsExactlyElementsIn(Point.fromArray(
            0, 0,
            1, 0,
            2, 0,
            2, 1,
            2, 2,
            2, 3,
            3, 3
        ));
  }
}
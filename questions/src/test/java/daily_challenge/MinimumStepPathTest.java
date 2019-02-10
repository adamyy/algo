package daily_challenge;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class MinimumStepPathTest {

  @Test
  public void findPath() {
    boolean[][] board = {
        {false, false, false, false},
        {true, true, false, true},
        {false, false, false, false},
        {false, false, false, false}
    };
    assertThat(MinimumStepPath.findPath(board, 3, 0, 0, 0)).isEqualTo(7);
  }
}
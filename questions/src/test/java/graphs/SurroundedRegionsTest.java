package graphs;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class SurroundedRegionsTest {

  @Test
  public void solve() {
    char[][] board = {
        {'O', 'X', 'X', 'O', 'X'},
        {'X', 'O', 'O', 'X', 'O'},
        {'X', 'O', 'X', 'O', 'X'},
        {'O', 'X', 'O', 'O', 'O'},
        {'X', 'X', 'O', 'X', 'O'}
    };
    char[][] expected = {
        {'O', 'X', 'X', 'O', 'X'},
        {'X', 'X', 'X', 'X', 'O'},
        {'X', 'X', 'X', 'O', 'X'},
        {'O', 'X', 'O', 'O', 'O'},
        {'X', 'X', 'O', 'X', 'O'}
    };

    assertThat(SurroundedRegions.solve(board)).isEqualTo(expected);
  }
}
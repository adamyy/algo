package graphs;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class WordSearchTest {

  @Test
  public void exist() {
    char[][] board1 = {
        {'A', 'B', 'C', 'E'},
        {'S', 'F', 'C', 'S'},
        {'A', 'D', 'E', 'E'}
    };

    assertThat(WordSearch.exist(board1, "ABCCED")).isTrue();
    assertThat(WordSearch.exist(board1, "SEE")).isTrue();
    assertThat(WordSearch.exist(board1, "ABCB")).isFalse();

    char[][] board2 = {
        {'A', 'B', 'C', 'E'},
        {'S', 'F', 'E', 'S'},
        {'A', 'D', 'E', 'E'}
    };
    assertThat(WordSearch.exist(board2, "ABCESEEEFS")).isTrue();
  }
}
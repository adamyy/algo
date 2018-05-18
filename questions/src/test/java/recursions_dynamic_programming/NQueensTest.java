package recursions_dynamic_programming;

import org.junit.Test;

import java.util.Arrays;

import static com.google.common.truth.Truth.*;

public class NQueensTest {

  @Test
  public void solveNQueens() {
    assertThat(NQueens.solveNQueens(4)).containsExactly(
        Arrays.asList(".Q..", "...Q", "Q...", "..Q."),
        Arrays.asList("..Q.", "Q...", "...Q", ".Q..")
    );
  }
}
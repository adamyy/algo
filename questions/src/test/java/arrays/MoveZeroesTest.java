package arrays;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class MoveZeroesTest {

  @Test
  public void moveZeroes() {
    assertThat(MoveZeroes.moveZeroes(new int[]{0, 1, 0, 3, 12}))
        .asList().containsExactly(1, 3, 12, 0, 0);
  }
}
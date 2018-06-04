package arrays;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class SetMatrixZeroesTest {

  @Test
  public void setZeroes() {
    assertThat(SetMatrixZeroes.setZeroes(new int[][]{
        new int[]{1, 0, 3},
    })).isEqualTo(new int[][]{
        new int[]{0, 0, 0},
    });

    assertThat(SetMatrixZeroes.setZeroes(new int[][]{
        new int[]{1, 1, 1},
        new int[]{1, 0, 1},
        new int[]{1, 1, 1},
    })).isEqualTo(new int[][]{
        new int[]{1, 0, 1},
        new int[]{0, 0, 0},
        new int[]{1, 0, 1},
    });

    assertThat(SetMatrixZeroes.setZeroes(new int[][]{
        new int[]{0, 1, 2, 0},
        new int[]{3, 4, 5, 2},
        new int[]{1, 3, 1, 5}
    })).isEqualTo(new int[][]{
        new int[]{0, 0, 0, 0},
        new int[]{0, 4, 5, 0},
        new int[]{0, 3, 1, 0},
    });
  }
}
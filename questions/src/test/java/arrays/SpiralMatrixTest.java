package arrays;

import org.junit.Test;

import java.util.Arrays;

import static com.google.common.truth.Truth.*;

public class SpiralMatrixTest {

  @Test
  public void spiralOrder() {
    int[][] firstMatrix = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}
    };
    assertThat(SpiralMatrix.spiralOrder(firstMatrix))
        .isEqualTo(Arrays.asList(1, 2, 3, 6, 9, 8, 7, 4, 5));

    int[][] secondMatrix = {
        {1, 2, 3, 4},
        {5, 6, 7, 8},
        {9, 10, 11, 12}
    };
    assertThat(SpiralMatrix.spiralOrder(secondMatrix))
        .isEqualTo(Arrays.asList(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7));
  }
}
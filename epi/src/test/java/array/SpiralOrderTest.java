package array;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class SpiralOrderTest {

  @Test
  public void spiralOrder() {
    int[][] matrix = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}
    };
    assertThat(SpiralOrder.spiralOrder(matrix))
        .containsExactly( 1, 2, 3, 6, 9, 8, 7, 4, 5)
        .inOrder();
  }
}
package array;

import java.util.LinkedList;
import java.util.List;

public class SpiralOrder {
  public static List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> result = new LinkedList<>();

    for (int offset = 0; offset < Math.ceil(0.5 * matrix.length); offset++) {
      if (matrix.length == 2 * offset + 1) {
        // matrix has odd dimension and we reached the center
        result.add(matrix[offset][offset]);
        break;
      }

      // right
      for (int i = offset; i < matrix.length - offset - 1; i++) {
        result.add(matrix[offset][i]);
      }

      // down
      for (int j = offset; j < matrix.length - offset - 1; j++) {
        result.add(matrix[j][matrix.length - offset - 1]);
      }

      // left
      for (int i = matrix.length - offset - 1; i > offset; i--) {
        result.add(matrix[matrix.length - offset - 1][i]);
      }

      // up
      for (int j = matrix.length - offset - 1; j > offset; j--) {
        result.add(matrix[j][offset]);
      }
    }

    return result;
  }
}

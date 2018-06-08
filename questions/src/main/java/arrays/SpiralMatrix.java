package arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 *
 * Example 1:
 *
 * Input:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 * Example 2:
 *
 * Input:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class SpiralMatrix {
  public static List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> result = new ArrayList<>();
    if (matrix.length == 0 || matrix[0].length == 0) return result;

    int rowBegin = 0;
    int colBegin = 0;
    int rowEnd = matrix.length - 1;
    int colEnd = matrix[0].length - 1;

    while (rowBegin <= rowEnd && colBegin <= colEnd) {
      for (int j = colBegin; j <= colEnd; j++) {
        result.add(matrix[rowBegin][j]);
      }
      rowBegin++;

      for (int i = rowBegin; i <= rowEnd; i++) {
        result.add(matrix[i][colEnd]);
      }
      colEnd--;

      if (rowBegin <= rowEnd) {
        for (int j = colEnd; j >= colBegin; j--) {
          result.add(matrix[rowEnd][j]);
        }
        rowEnd--;
      }

      if (colBegin <= colEnd) {
        for (int i = rowEnd; i >= rowBegin; i--) {
          result.add(matrix[i][colBegin]);
        }
        colBegin++;
      }
    }

    return result;
  }
}

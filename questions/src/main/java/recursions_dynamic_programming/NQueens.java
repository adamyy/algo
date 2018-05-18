package recursions_dynamic_programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 * <p>
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * <p>
 * Each solution contains a distinct board configuration of the n-queens' placement,
 * where 'Q' and '.' both indicate a queen and an empty space respectively.
 * <p>
 * Example:
 * <p>
 * Input: 4
 * Output: [
 * [".Q..",  // Solution 1
 * "...Q",
 * "Q...",
 * "..Q."],
 * <p>
 * ["..Q.",  // Solution 2
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 * Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.
 */
public class NQueens {
  public static List<List<String>> solveNQueens(int n) {
    if (n <= 0) return null;

    List<List<String>> result = new LinkedList<>();

    int[] columns = new int[n];
    char[][] board = new char[n][n];
    for (int index = 0; index < n; index++) {
      Arrays.fill(board[index], '.');
    }

    backtrack(0, columns, board, result);

    return result;
  }

  // assume any 0..row-1 has already been arranged
  private static void backtrack(int row, int[] columns, char[][] board, List<List<String>> result) {
    if (row == board.length) {
      List<String> solution = new ArrayList<>();
      for (char[] arr : board) {
        solution.add(String.copyValueOf(arr));
      }
      result.add(solution);
    }

    for (int col = 0; col < board.length; col++) {
      if (validPlace(row, col, columns)) {
        board[row][col] = 'Q';
        columns[row] = col;
        backtrack(row + 1, columns, board, result);
        board[row][col] = '.';
      }
    }
  }

  private static boolean validPlace(int newRow, int newCol, int[] oldColumns) {
    for (int oldRow = 0; oldRow < newRow; oldRow++) {
      int oldCol = oldColumns[oldRow];

      // check column
      if (oldCol == newCol) return false;

      // check diagonal
      int rowDistance = Math.abs(oldRow - newRow);
      int colDistance = Math.abs(oldCol - newCol);
      if (rowDistance == colDistance) return false;
    }
    return true;
  }
}

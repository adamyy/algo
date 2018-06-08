package graphs;

import java.util.Arrays;

/**
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
 * <p>
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 * <p>
 * Example:
 * <p>
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * After running your function, the board should be:
 * <p>
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * Explanation:
 * <p>
 * Surrounded regions shouldn’t be on the border,
 * which means that any 'O' on the border of the board are not flipped to 'X'.
 * Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'.
 * Two cells are connected if they are adjacent cells connected horizontally or vertically.
 */
public class SurroundedRegions {
  public static char[][] solve(char[][] board) {
    if (board.length <= 1 || board[0].length <= 1) return board;
    int m = board.length, n = board[0].length;
    for (int i = 0; i < m; i++) {
      if (board[i][0] == 'O') dfs(i, 0, 'O', '*', board);
      if (board[i][n - 1] == 'O') dfs(i, n - 1, 'O', '*', board);
    }

    for (int j = 0; j < n; j++) {
      if (board[0][j] == 'O') dfs(0, j, 'O', '*', board);
      if (board[m - 1][j] == 'O') dfs(m - 1, j, 'O', '*', board);
    }

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (board[i][j] == 'O') board[i][j] = 'X';
        else if (board[i][j] == '*') board[i][j] = 'O';
      }
    }

    return board;
  }

  private static int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

  private static void dfs(int x, int y, char flipWhen, char flipTo, char[][] board) {
    if (!validIndices(x, y, board) || board[x][y] != flipWhen) return;
    board[x][y] = flipTo;

    for (int[] direction : directions) {
      int newX = x + direction[0];
      int newY = y + direction[1];
      dfs(newX, newY, flipWhen, flipTo, board);
    }
  }

  private static boolean validIndices(int x, int y, char[][] board) {
    return x >= 0 && x < board.length && y >= 0 && y < board[0].length;
  }
}

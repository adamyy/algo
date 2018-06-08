package graphs;

/**
 * Given a 2D board and a word, find if the word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 *
 * Example:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 */
public class WordSearch {
  public static boolean exist(char[][] board, String word) {
    if (board.length == 0 || board[0].length == 0) return false;
    int n = board.length;
    int m = board[0].length;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (word.charAt(0) == board[i][j]) {
          if (dfs(board, word, 0, i, j, new boolean[n][m])) return true;
        }
      }
    }

    return false;
  }

  private static boolean dfs(char[][] board, String word, int index, int row, int col, boolean[][] visited) {
    if (index == word.length()) return true;
    if (invalidIndex(board, row, col)) return false;
    if (visited[row][col]) return false;
    if (board[row][col] != word.charAt(index)) return false;

    visited[row][col] = true;
    if (dfs(board, word, index + 1, row + 1, col, visited)) return true;
    if (dfs(board, word, index + 1, row - 1, col, visited)) return true;
    if (dfs(board, word, index + 1, row, col + 1, visited)) return true;
    if (dfs(board, word, index + 1, row, col - 1, visited)) return true;

    visited[row][col] = false;
    return false;
  }

  private static boolean invalidIndex(char[][] board, int row, int col) {
    return row < 0 || row >= board.length || col < 0 || col >= board[0].length;
  }
}

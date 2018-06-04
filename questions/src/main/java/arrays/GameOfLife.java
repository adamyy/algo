package arrays;

import java.util.HashMap;

/**
 * According to the Wikipedia's article: "The Game of Life, also known simply as Life,
 * is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
 * <p>
 * Given a board with m by n cells, each cell has an initial state live (1) or dead (0).
 * Each cell interacts with its eight neighbors (horizontal, vertical, diagonal)
 * using the following four rules (taken from the above Wikipedia article):
 * <p>
 * 1. Any live cell with fewer than two live neighbors dies, as if caused by under-population.
 * 2. Any live cell with two or three live neighbors lives on to the next generation.
 * 3. Any live cell with more than three live neighbors dies, as if by over-population..
 * 4. Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 * <p>
 * Write a function to compute the next state (after one update) of the board given its current state.
 * <p>
 * Follow up:
 * Could you solve it in-place?
 * Remember that the board needs to be updated at the same time:
 * You cannot update some cells first and then use their updated values to update other cells.
 * <p>
 * In this question, we represent the board using a 2D array.
 * In principle, the board is infinite, which would cause problems when the active area encroaches the border of the array.
 * How would you address these problems?
 */
public class GameOfLife {
  private static int D2D = -1;
  private static int D2L = -2;
  private static int L2D = -3;
  private static int L2L = -4;

  public void gameOfLife(int[][] board) {
    if (board.length == 0 || board[0].length == 0) return;
    int rows = board.length, cols = board[0].length;

    // transition cell to intermediate states
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        int aliveNeighbors = aliveNeighbors(board, i, j);
        if (board[i][j] == 0) {
          if (aliveNeighbors == 3) board[i][j] = D2L;
          else board[i][j] = D2D;
        } else {
          if (aliveNeighbors < 2 || aliveNeighbors > 3) board[i][j] = L2D;
          else board[i][j] = L2L;
        }
      }
    }

    // for (int[] row: board) System.out.println(Arrays.toString(row));

    // transition cell to terminal states
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (board[i][j] == D2D) board[i][j] = 0;
        else if (board[i][j] == D2L) board[i][j] = 1;
        else if (board[i][j] == L2D) board[i][j] = 0;
        else if (board[i][j] == L2L) board[i][j] = 1;
      }
    }
  }

  private static final int[][] directions = {
      {0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}
  };

  private int aliveNeighbors(int[][] board, int row, int col) {
    int count = 0;
    for (int[] direction : directions) {
      int newRow = row + direction[0], newCol = col + direction[1];
      if (validIndex(board, newRow, newCol)) {
        if (board[newRow][newCol] == 1 ||
            board[newRow][newCol] == L2D ||
            board[newRow][newCol] == L2L) {
          count++;
        }
      }
    }
    return count;
  }

  private boolean validIndex(int[][] board, int row, int col) {
    return row >= 0 && row < board.length && col >= 0 && col < board[0].length;
  }
}

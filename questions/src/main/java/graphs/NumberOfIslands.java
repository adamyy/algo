package graphs;

/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 *
 * Example 1:
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 * Output: 1
 *
 * Example 2:
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 * Output: 3
 */
public class NumberOfIslands {

  private static final int[][] DIRECTIONS = new int[][] {
      new int[] {0, 1},
      new int[] {1, 0},
      new int[] {0, -1},
      new int[] {-1, 0},
  };
  private static final char WATER = '0';
  private static final char LAND = '1';

  public static int numIslands(char[][] grid) {
    int numIslands = 0;

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == LAND) {
          numIslands++;
          dfsVisit(grid, i, j);
        }
      }
    }

    return numIslands;
  }

  private static void dfsVisit(char[][] grid, int x, int y) {
    if (!validIndices(grid, x, y) || grid[x][y] == WATER) return;

    grid[x][y] = WATER;

    for (int[] direction: DIRECTIONS) dfsVisit(grid, x + direction[0], y + direction[1]);
  }

  private static boolean validIndices(char[][] grid, int x, int y) {
    return (x >= 0 && x < grid.length) && (y >= 0 && y < grid[0].length);
  }
}

package daily_challenge;

import java.util.LinkedList;
import java.util.Queue;

/**
 * This problem was asked by Google.
 *
 * You are given an M by N matrix consisting of booleans that represents a board.
 * Each True boolean represents a wall. Each False boolean represents a tile you can walk on.
 *
 * Given this matrix, a start coordinate, and an end coordinate,
 * return the minimum number of steps required to reach the end coordinate from the start.
 *
 * If there is no possible path, then return null.
 * You can move up, left, down, and right.
 * You cannot move through walls.
 * You cannot wrap around the edges of the board.
 *
 * For example, given the following board:
 *
 * [[f, f, f, f],
 * [t, t, f, t],
 * [f, f, f, f],
 * [f, f, f, f]]
 *
 * and start = (3, 0) (bottom left) and end = (0, 0) (top left),
 * the minimum number of steps required to reach the end is 7,
 * since we would need to go through (1, 2) because there is a wall everywhere else on the second row.
 */
public class MinimumStepPath {
  static class Pair<X, Y> {
    X x;
    Y y;

    public Pair(X x, Y y) {
      this.x = x;
      this.y = y;
    }
  }

  static class Location extends Pair<Integer, Integer> {
    Location(int x, int y) {
      super(x, y);
    }

    Location move(Location move) {
      return new Location(this.x + move.x, this.y + move.y);
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Location location = (Location) o;
      if (!x.equals(location.x)) return false;
      return y.equals(location.y);
    }

    @Override
    public int hashCode() {
      int result = x.hashCode();
      result = 31 * result + y.hashCode();
      return result;
    }
  }

  static class Context {
    final Location location;
    final int moves;

    public Context(Location location, int moves) {
      this.location = location;
      this.moves = moves;
    }
  }

  private static final Location[] moves = {
      new Location(0, 1),
      new Location(1, 0),
      new Location(0, -1),
      new Location(-1, 0),
  };

  public static int findPath(boolean[][] board, int startX, int startY, int endX, int endY) {
    Location start = new Location(startX, startY);
    Location end = new Location(endX, endY);

    Queue<Context> queue = new LinkedList<>();
    queue.offer(new Context(start, 0));
    boolean[][] visited = new boolean[board.length][board[0].length];
    visited[startX][startY] = true;

    while (!queue.isEmpty()) {
      Context context = queue.poll();
      Location location = context.location;
      if (location.equals(end)) return context.moves;
      for (Location move: moves) {
        if (!canMove(board, visited, location, move)) continue;
        Location next = location.move(move);
        visited[next.x][next.y] = true;
        queue.offer(new Context(next, context.moves + 1));
      }
    }

    return -1;
  }

  private static boolean canMove(boolean[][] board, boolean[][] visited, Location pos, Location move) {
    Location end = pos.move(move);
    if (end.x < 0 || end.x >= board.length) return false;
    if (end.y < 0 || end.y >= board[0].length) return false;
    return !visited[end.x][end.y]
        && !board[end.x][end.y];
  }
}

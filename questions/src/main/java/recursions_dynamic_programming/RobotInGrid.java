package recursions_dynamic_programming;

import lib.Point;

import java.util.HashSet;
import java.util.LinkedList;

/**
 * Imagine a robot sitting on the bottom left corner of grid with r rows and c columns.
 * The robot can only move in two directions, right and up,
 * but certain cells are "off limits" such that the robot cannot step on them.
 * Design an algorithm to find a path for the robot from the bottom left to the top right.
 */
public class RobotInGrid {
  public static LinkedList<Point> getPath(boolean[][] maze) {
    if (maze == null || maze.length == 0 || maze[0].length == 0) return null;
    LinkedList<Point> path = new LinkedList<>();
    HashSet<Point> visited = new HashSet<>();
    path.addLast(new Point(0, 0));
    if (dfs(maze, path, visited)) return path;
    return null;
  }

  private static boolean dfs(boolean[][] maze, LinkedList<Point> path, HashSet<Point> visited) {
    Point curr = path.getLast();
    if (!validPosition(curr.x, curr.y, maze) || !maze[curr.x][curr.y]) return false;
    if (visited.contains(curr)) return false;
    if (atDestination(curr.x, curr.y, maze)) return true;

    Point right = new Point(curr.x + 1, curr.y);
    path.addLast(right);
    if (dfs(maze, path, visited)) {
      return true;
    } else {
      path.removeLast();
    }

    Point up = new Point(curr.x, curr.y + 1);
    path.addLast(up);
    if (dfs(maze, path, visited)) {
      return true;
    } else {
      path.removeLast();
    }

    visited.add(curr);
    return false;
  }

  private static boolean atDestination(int x, int y, boolean[][] maze) {
    return x == maze.length - 1 && y == maze[0].length - 1;
  }

  private static boolean validPosition(int x, int y, boolean[][] maze) {
    return (x >= 0 && x < maze.length) && (y >= 0 && y < maze[0].length);
  }
}

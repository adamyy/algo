package graphs;

import java.security.InvalidParameterException;
import java.util.*;

/**
 * Build Order: You are given a list of projects and a list of dependencies
 * (which is a list of pairs of projects, where the second project is dependent on the first project).
 * All of a project's dependencies must be built before the project is.
 * Find a build order that will allow the projects to be built. If there is no valid build order, return an error.
 *
 * EXAMPLE
 * Input:
 *  projects: a, b, c, d, e, f
 *  dependencies: (a, d), (f, b), (b, d), (f, a), (d, c)
 *
 * Output: f, e, a, b, d, c
 */
public class BuildOrder {
  enum Color { WHITE, GRAY, BLACK }

  public static String[] buildOrder(String[] projects, String[][] dependencies) {
    Map<String, Set<String>> adjacencyMap = new HashMap<>();
    for (String project : projects) adjacencyMap.put(project, new HashSet<>());
    for (String[] edge : dependencies) adjacencyMap.get(edge[1]).add(edge[0]);

    Stack<String> stack = new Stack<>();
    Map<String, Color> colors = new HashMap<>();
    for (String project : projects) colors.put(project, Color.WHITE);

    for (String project : projects) {
      if (!dfs(project, stack, colors, adjacencyMap)) {
        throw new InvalidParameterException("Circular dependencies!");
      }
    }

    String[] result = new String[projects.length];
    stackToArray(stack, result);
    return result;
  }

  /**
   * @param node the node being visited
   * @param buildOrder projects build order
   * @param colors current state of the node
   * @param adjacencyMap graph
   * @return true if no cycle has been detected, false otherwise
   */
  private static boolean dfs(String node, Stack<String> buildOrder, Map<String, Color> colors, Map<String, Set<String>> adjacencyMap) {
    if (colors.get(node) == Color.GRAY) return false; // cycle

    if (colors.get(node) == Color.WHITE) {
      colors.put(node, Color.GRAY);
      for (String child: adjacencyMap.get(node)) {
        if (!dfs(child, buildOrder, colors, adjacencyMap)) {
          return false;
        }
      }

      colors.put(node, Color.BLACK);
      buildOrder.push(node);
    }

    return true;
  }

  private static void stackToArray(Stack<String> stack, String[] array) {
    int index = 0;
    while(!stack.empty()) array[index++] = stack.pop();
  }
}

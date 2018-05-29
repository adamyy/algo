package graphs;

import java.util.*;

/**
 * For a undirected graph with tree characteristics, we can choose any node as the root. The result graph is then a rooted tree.
 * Among all possible rooted trees, those with minimum height are called minimum height trees (MHTs).
 * Given such a graph, write a function to find all the MHTs and return a list of their root labels.
 * <p>
 * Format
 * The graph contains n nodes which are labeled from 0 to n - 1.
 * You will be given the number n and a list of undirected edges (each edge is a pair of labels).
 * <p>
 * You can assume that no duplicate edges will appear in edges. Since all edges are undirected,
 * [0, 1] is the same as [1, 0] and thus will not appear together in edges.
 * <p>
 * Example 1 :
 * <p>
 * Input: n = 4, edges = [[1, 0], [1, 2], [1, 3]]
 * <p>
 * 0
 * |
 * 1
 * / \
 * 2   3
 * <p>
 * Output: [1]
 * Example 2 :
 * <p>
 * Input: n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]
 * <p>
 * 0  1  2
 * \ | /
 * 3
 * |
 * 4
 * |
 * 5
 * <p>
 * Output: [3, 4]
 */
public class MinimumHeightTrees {
  public static List<Integer> minimumHeightTrees(int n, int[][] edges) {
    if (n == 0) return Collections.EMPTY_LIST;
    if (n == 1) return Collections.singletonList(0);

    List<HashSet<Integer>> graph = new ArrayList<>();
    for (int i = 0; i < n; i++) graph.add(new HashSet<>());
    for (int[] edge : edges) {
      graph.get(edge[0]).add(edge[1]);
      graph.get(edge[1]).add(edge[0]);
    }

    LinkedList<Integer> leaves = new LinkedList<>();

    for (int i = 0; i < graph.size(); i++) {
      if (graph.get(i).size() == 1) {
        leaves.offer(i);
      }
    }

    while (n > 2) {
      n -= leaves.size();

      LinkedList<Integer> newLeaves = new LinkedList<>();

      while (!leaves.isEmpty()) {
        int leave = leaves.poll();
        // delete leave from the graph
        int branch = graph.get(leave).iterator().next();
        graph.get(leave).remove(branch);
        graph.get(branch).remove(leave);

        if (graph.get(branch).size() == 1) newLeaves.offer(branch);
      }

      leaves = newLeaves;
    }

    return leaves;
  }
}

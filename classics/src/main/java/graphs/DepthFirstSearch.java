package graphs;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.function.Consumer;

public class DepthFirstSearch {
  public static void depthFirstSearch(
      UnweightedGraph graph,
      int vertex,
      Consumer<Integer> action
  ) {
    Set<Integer> visitedSet = new HashSet<>();
    Stack<Integer> stack = new Stack<>();
    stack.push(vertex);

    while (!stack.empty()) {
      int curr = stack.pop();
      visitedSet.add(curr);
      action.accept(curr);

      Iterable<Integer> adjacents = graph.getAdjacents(curr);
      for (int adjacentVertex: adjacents) {
        if (!visitedSet.contains(adjacentVertex)) {
          stack.push(adjacentVertex);
        }
      }
    }
  }
}

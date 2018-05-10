package jparkie.graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.function.Consumer;

public class BreadthFirstSearch {
  public static void breadthFirstSearch(
      UnweightedGraph graph,
      int vertex,
      Consumer<Integer> consumer
  ) {
    Set<Integer> visitedSet = new HashSet<>();
    Queue<Integer> queue = new LinkedList<>();
    queue.offer(vertex);

    while (!queue.isEmpty()) {
      int curr = queue.poll();
      visitedSet.add(curr);
      consumer.accept(curr);

      Iterable<Integer> adjacents = graph.getAdjacents(curr);
      for (int neighbor: adjacents) {
        if (visitedSet.contains(neighbor)) continue;
        queue.offer(neighbor);
      }
    }
  }
}

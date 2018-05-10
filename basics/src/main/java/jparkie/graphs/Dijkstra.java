package jparkie.graphs;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Dijkstra {

  /*
   * Dijkstra's Algorithm:
   * 1. Assume all vertices are an infinite distance from the source vertex.
   * 2. Assume the source vertex is zero distance from itself.
   * 3. Perform breadth-first search using a priority queue by distance.
   * 4. For every adjacent vertex visited, relax its edge.
   */
  public static List<WeightedEdge> shortestPath(
    WeightedGraph graph,
    int source,
    int destination
  ) {
    Map<Integer, Integer> distanceTo = new HashMap<>();
    Map<Integer, WeightedEdge> edgeTo = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    PriorityQueue<VertexDistancePair> priorityQueue = new PriorityQueue<>();

    // 1. Assume all vertices are an infinite distance from the source vertex.
    for (int vertex = 0; vertex < graph.getVertices(); vertex++) {
      distanceTo.put(vertex, Integer.MAX_VALUE);
    }

    // 2. Assume the source vertex is zero distance from itself.
    distanceTo.put(source, 0);

    priorityQueue.offer(new VertexDistancePair(source, distanceTo.get(source)));

    // 3. Perform breadth-first search using a priority queue by distance.
    while (!priorityQueue.isEmpty()) {
      int minimumVertex = priorityQueue.poll().vertex;
      visited.add(minimumVertex);
      for (WeightedEdge adjacentEdge: graph.getAdjacents(minimumVertex)) {
        int start = adjacentEdge.start;
        int end = adjacentEdge.end;
        int weight = adjacentEdge.weight;
        if (!visited.contains(end)) {
          // 4. For every adjacent vertex visited, relax its edge.
          if (distanceTo.get(end) > distanceTo.get(start) + weight) {
            distanceTo.put(end, distanceTo.get(start) + weight);
            edgeTo.put(end, adjacentEdge);
            priorityQueue.offer(new VertexDistancePair(end, distanceTo.get(end)));
          }
        }
      }
    }

    return buildPath(edgeTo, destination);
  }

  private static List<WeightedEdge> buildPath(
      Map<Integer, WeightedEdge> edgeTo,
      int destination
  ) {
    LinkedList<WeightedEdge> path = new LinkedList<>();
    int currentVertex = destination;
    while (edgeTo.containsKey(currentVertex)) {
      WeightedEdge edge = edgeTo.get(currentVertex);
      path.addFirst(edge);
      currentVertex = edge.start;
    }
    return path;
  }

  static class VertexDistancePair implements Comparable<VertexDistancePair> {
    final int vertex;
    final int distance;

    VertexDistancePair(int vertex, int distance) {
      this.vertex = vertex;
      this.distance = distance;
    }

    @Override
    public int compareTo(@NotNull VertexDistancePair o) {
      return Integer.compare(this.distance, o.distance);
    }
  }
}

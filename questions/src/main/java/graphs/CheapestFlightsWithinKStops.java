package graphs;

import java.util.*;

/**
 * There are n cities connected by m flights. Each fight starts from city u and arrives at v with a price w.
 *
 * Now given all the cities and fights, together with starting city src and the destination dst,
 * your task is to find the cheapest price from src to dst with up to k stops.
 *
 * If there is no such route, output -1.
 *
 * Example 1:
 * Input:
 *    n = 3,
 *    edges = [[0,1,100],[1,2,100],[0,2,500]],
 *    src = 0,
 *    dst = 2,
 *    k = 1
 * Output: 200
 *
 * The cheapest price from city 0 to city 2 with at most 1 stop costs 200
 *
 * Example 2:
 * Input:
 *    n = 3,
 *    edges = [[0,1,100],[1,2,100],[0,2,500]]
 *    src = 0,
 *    dst = 2,
 *    k = 0
 * Output: 500
 *
 * The cheapest price from city 0 to city 2 with at most 0 stop costs 500
 *
 * Note:
 *
 * The number of nodes n will be in range [1, 100], with nodes labeled from 0 to n - 1.
 * The size of flights will be in range [0, n * (n - 1) / 2].
 * The format of each flight will be (src, dst, price).
 * The price of each flight will be in the range [1, 10000].
 * k is in the range of [0, n - 1].
 * There will not be any duplicated flights or self cycles.
 */
public class CheapestFlightsWithinKStops {
  public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
    Map<Integer, Integer> distanceTo = new HashMap<>();
    Map<Integer, Integer> stopsTo = new HashMap<>();
    PriorityQueue<VertexDistancePair> priorityQueue = new PriorityQueue<>();
    WeightedEdge[][] graph = new WeightedEdge[n][n];
    for (int[] flight: flights) graph[flight[0]][flight[1]] = new WeightedEdge(flight[0], flight[1], flight[2]);
    for (int i = 0; i < n; i++) distanceTo.put(i, Integer.MAX_VALUE);
    for (int i = 0; i < n; i++) stopsTo.put(i, Integer.MAX_VALUE);
    distanceTo.put(src, 0);
    stopsTo.put(src, 0);

    priorityQueue.offer(new VertexDistancePair(0, src, 0));

    while (!priorityQueue.isEmpty()) {
      VertexDistancePair pair = priorityQueue.poll();

      if (pair.vertex == dst) continue;
      if (pair.stops == K + 1) continue;

      WeightedEdge[] edges = graph[pair.vertex];

      for (WeightedEdge edge: edges) {
        if (edge == null) continue;

        int newDistance = pair.distance + edge.weight;
        int newStops = pair.stops + 1;

        if (distanceTo.get(edge.to) > newDistance) {
          distanceTo.put(edge.to, newDistance);
          priorityQueue.offer(new VertexDistancePair(newStops, edge.to, newDistance));
        }

        if (stopsTo.get(edge.to) > newStops) {
          stopsTo.put(edge.to, newStops);
          priorityQueue.offer(new VertexDistancePair(newStops, edge.to, newDistance));
        }
      }
    }

    if (distanceTo.get(dst) == Integer.MAX_VALUE) return -1;
    return distanceTo.get(dst);
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
      currentVertex = edge.from;
    }
    return path;
  }

  static class WeightedEdge {
    final int from, to;
    final int weight;
    public WeightedEdge(int from, int to, int weight) {
      this.from = from;
      this.to = to;
      this.weight = weight;
    }
  }

  static class VertexDistancePair implements Comparable<VertexDistancePair> {
    final int stops;
    final int vertex;
    final int distance;
    public VertexDistancePair(int stops, int vertex, int distance) {
      this.stops = stops;
      this.vertex = vertex;
      this.distance = distance;
    }

    @Override
    public int compareTo(VertexDistancePair o) {
      return Integer.compare(this.distance, o.distance);
    }
  }
}

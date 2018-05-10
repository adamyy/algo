package jparkie.graphs;

import java.util.ArrayList;
import java.util.LinkedList;

public class ListGraph implements UnweightedGraph {
  private final ArrayList<LinkedList<Integer>> adjacencyList;
  private final int vertices;

  public ListGraph(int vertices) {
    this.adjacencyList = new ArrayList<>(vertices);
    for (int i = 0; i < vertices; i++) {
      adjacencyList.add(new LinkedList<Integer>());
    }
    this.vertices = vertices;
  }

  @Override
  public void addEdge(int u, int v) {
    adjacencyList.get(u).add(v);
  }

  @Override
  public int getVertices() {
    return vertices;
  }

  @Override
  public Iterable<Integer> getAdjacents(int v) {
    return adjacencyList.get(v);
  }
}

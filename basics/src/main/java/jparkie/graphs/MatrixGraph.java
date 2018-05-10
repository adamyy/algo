package jparkie.graphs;

import java.util.LinkedList;

public class MatrixGraph implements UnweightedGraph {
  private final boolean[][] adjacencyMatrix;
  private final int vertices;

  public MatrixGraph(int vertices) {
    this.adjacencyMatrix = new boolean[vertices][vertices];
    this.vertices = vertices;
  }

  @Override
  public void addEdge(int u, int v) {
    adjacencyMatrix[u][v] = true;
  }

  @Override
  public int getVertices() {
    return vertices;
  }

  @Override
  public Iterable<Integer> getAdjacents(int v) {
    boolean[] adjacencyVector = adjacencyMatrix[v];
    LinkedList<Integer> adjacencyList = new LinkedList<>();
    for (int vertex = 0; vertex < vertices; vertex++) {
      if (adjacencyVector[vertex]) adjacencyList.add(vertex);
    }
    return adjacencyList;
  }
}

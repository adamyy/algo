package jparkie.graphs;

import java.util.LinkedList;

public class WeightedEdgesMatrixGraph implements WeightedGraph {
  private final WeightedEdge[][] adjacencyMatrix;
  private final int vertices;


  public WeightedEdgesMatrixGraph(int vertices) {
    this.adjacencyMatrix = new WeightedEdge[vertices][vertices];
    this.vertices = vertices;
  }

  @Override
  public void addEdge(int u, int v, int weight) {
    adjacencyMatrix[u][v] = new WeightedEdge(u, v, weight);
  }

  @Override
  public int getVertices() {
    return vertices;
  }

  @Override
  public Iterable<WeightedEdge> getAdjacents(int v) {
    WeightedEdge[] adjacencyVector = adjacencyMatrix[v];
    LinkedList<WeightedEdge> adjacencyList = new LinkedList<>();
    for (int vertex = 0; vertex < vertices; vertex++) {
      if (adjacencyVector[vertex] != null) adjacencyList.add(adjacencyVector[vertex]);
    }
    return adjacencyList;
  }

  @Override
  public Iterable<WeightedEdge> getEdges() {
    LinkedList<WeightedEdge> edges = new LinkedList<>();
    for (int u = 0; u < vertices; u++) {
      for (int v = 0; v < vertices; v++) {
        if (adjacencyMatrix[u][v] != null) edges.add(adjacencyMatrix[u][v]);
      }
    }
    return edges;
  }
}

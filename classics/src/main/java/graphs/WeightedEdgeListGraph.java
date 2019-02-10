package graphs;

import java.util.ArrayList;
import java.util.LinkedList;

public class WeightedEdgeListGraph implements WeightedGraph {
  private final ArrayList<LinkedList<WeightedEdge>> adjacencyList;
  private final int vertices;

  public WeightedEdgeListGraph(int vertices) {
    this.adjacencyList = new ArrayList<>(vertices);
    for (int i = 0; i < vertices; i++) adjacencyList.add(new LinkedList<WeightedEdge>());
    this.vertices = vertices;
  }

  @Override
  public void addEdge(int u, int v, int weight) {
    adjacencyList.get(u).add(new WeightedEdge(u, v, weight));
  }

  @Override
  public Iterable<WeightedEdge> getAdjacents(int u) {
    return adjacencyList.get(u);
  }

  @Override
  public int getVertices() {
    return vertices;
  }

  @Override
  public Iterable<WeightedEdge> getEdges() {
    LinkedList<WeightedEdge> edges = new LinkedList<>();
    for (int vertex = 0; vertex < vertices; vertex++) {
      edges.addAll(adjacencyList.get(vertex));
    }
    return edges;
  }
}

package jparkie.graphs;

public interface WeightedGraph {
  void addEdge(int u, int v, int weight);
  int getVertices();
  Iterable<WeightedEdge> getAdjacents(int v);
  Iterable<WeightedEdge> getEdges();
}

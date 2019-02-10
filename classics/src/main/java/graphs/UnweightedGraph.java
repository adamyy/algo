package graphs;

public interface UnweightedGraph {
  void addEdge(int u, int v);
  int getVertices();
  Iterable<Integer> getAdjacents(int v);
}

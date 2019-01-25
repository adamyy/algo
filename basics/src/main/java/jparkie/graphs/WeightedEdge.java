package jparkie.graphs;

public class WeightedEdge implements Comparable<WeightedEdge> {
  public final int start;
  public final int end;
  public final int weight;

  public WeightedEdge(int start, int end, int weight) {
    this.start = start;
    this.end = end;
    this.weight = weight;
  }

  @Override
  public int compareTo(WeightedEdge o) {
    return 0;
  }
}

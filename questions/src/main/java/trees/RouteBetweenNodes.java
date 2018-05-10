package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a directed graph, design an algorithm to find out whether there is a route between two nodes.
 */
public class RouteBetweenNodes {
  static class Graph {
    public List<Vertex> vertices = new ArrayList<>();
  }

  static class Vertex {
    public List<Vertex> adjacentVertices = new ArrayList<>();
    public NodeState state = NodeState.WHITE;
  }

  enum NodeState {
    WHITE, // unvisited
    GRAY, // visited
    BLACK // exhausted
  }

  boolean search(Graph graph, Vertex start, Vertex end) {
    if (start == end) return true;

    Queue<Vertex> queue = new LinkedList<>();

    start.state = NodeState.GRAY;
    queue.offer(start);

    Vertex curr;
    while (!queue.isEmpty()) {
      curr = queue.remove();

      for (Vertex neighbor: curr.adjacentVertices) {
        if (neighbor.state == NodeState.WHITE) {
          if (neighbor == end) return true;
          neighbor.state = NodeState.GRAY;
          queue.offer(neighbor);
        }
      }

      curr.state = NodeState.BLACK;
    }

    return false;
  }
}

package pinterest;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Suppose we have some input data describing a graph of relationships between parents and children over multiple generations.
 * The data is formatted as a list of (parent, child) paris, where each individual is assigned a unique integer identifier;
 *
 * For example, in this diagram and the sample input, 3 is a child of 1 and 2, and 5 is a child of 4
 *
 *    10
 *   /
 *  1   2   4   11
 *   \ /   / \ /
 *    3   5   8
 *     \ / \   \
 *     6    7   9
 *
 * Write a function that, given the data set and the ID of an individual in the data set,
 * returns their earliest known ancestor - the one at the farthest distance from the input individual.
 * If there is more than one ancestor tied for "earliest", return the one with the lowest numeric ID.
 * If the input individual has no parents, the function should return -1
 *
 * Clarifications
 * - the input will not be empty
 * - there are no cycles in the input
 * - there are no "repeated" ancestors - if two individuals are connected, it is by exactly one path
 * - ids will always be positive integers
 * - a parent may have any number of children
 */
public class FarthestParent {

  public static class Pair {
    String parent;
    String child;

    public Pair(String parent, String child) {
      this.parent = parent;
      this.child = child;
    }
  }

  public static String earliestAncestor(String individual, List<Pair> parentChildPairs) {
    Map<String, List<String>> parentMap = new HashMap<>();
    for (Pair pair: parentChildPairs) {
      String parent = pair.parent;
      String child = pair.child;

      List<String> parents = parentMap.get(child);
      if (parents == null) parents = new LinkedList<>();

      parents.add(parent);

      parentMap.put(child, parents);
    }

    FindAncestorResult result = earliestAncestor(individual, parentMap);
    if (result.parent.equals(individual)) return "-1";
    else return result.parent;
  }

  private static class FindAncestorResult {
    int pathLength;
    String parent;

    public FindAncestorResult(int pathLength, String parent) {
      this.pathLength = pathLength;
      this.parent = parent;
    }
  }

  private static FindAncestorResult earliestAncestor(String individual, Map<String, List<String>> parentMap) {
    List<String> parents = parentMap.getOrDefault(individual, new LinkedList<>());
    FindAncestorResult result = new FindAncestorResult(0, individual);

    for (String parent: parents) {
      FindAncestorResult parentResult = earliestAncestor(parent, parentMap);
      if (parentResult.pathLength + 1 > result.pathLength) {
        result.pathLength = parentResult.pathLength + 1;
        result.parent = parentResult.parent;
      } else if (parentResult.pathLength + 1 == result.pathLength) {
        int currentID = Integer.parseInt(result.parent);
        int otherID = Integer.parseInt(parentResult.parent);
        if (otherID < currentID) result.parent = parentResult.parent;
      }
    }

    return result;
  }
}

package trees;

import lib.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * A binary search tree was created by traversing through an array from left to right and inserting each element.
 * Given a binary search tree with distinct elements, print all possible arrays that could have led to this tree.
 *
 * EXAMPLE
 * Input:
 *        2
 *       / \
 *      1   3
 * Output: {2, 1, 3}, {2, 3, 1}
 */
public class BSTSequence {
  public static ArrayList<LinkedList<Integer>> allSequences(TreeNode node) {
    ArrayList<LinkedList<Integer>> result = new ArrayList<>();

    if (node == null) {
      result.add(new LinkedList<>());
      return result;
    }

    LinkedList<Integer> prefix = new LinkedList<>();
    prefix.add(node.val);

    ArrayList<LinkedList<Integer>> leftSeq = allSequences(node.left);
    ArrayList<LinkedList<Integer>> rightSeq = allSequences(node.right);

    for (LinkedList<Integer> left : leftSeq) {
      for (LinkedList<Integer> right : rightSeq) {
        ArrayList<LinkedList<Integer>> weaved = new ArrayList<>();
        weaveLists(left, right, prefix, weaved);
        result.addAll(weaved);
      }
    }

    return result;
  }

  private static void weaveLists(
      LinkedList<Integer> first,
      LinkedList<Integer> second,
      LinkedList<Integer> prefix,
      ArrayList<LinkedList<Integer>> weaved) {
    if (first.isEmpty() || second.isEmpty()) {
      LinkedList<Integer> result = (LinkedList<Integer>) prefix.clone();
      result.addAll(first);
      result.addAll(second);
      weaved.add(result);
      return;
    }

    int headFirst = first.removeFirst();
    prefix.addLast(headFirst);
    weaveLists(first, second, prefix, weaved);
    prefix.removeLast();
    first.addFirst(headFirst);

    int headSecond = second.removeFirst();
    prefix.addLast(headSecond);
    weaveLists(first, second, prefix, weaved);
    prefix.removeLast();
    second.addFirst(headSecond);
  }
}

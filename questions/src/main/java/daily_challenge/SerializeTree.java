package daily_challenge;

import tags.TreeTraversal;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * This problem was asked by Google.
 *
 * Given the root to a binary tree, implement serialize(root),
 * which serializes the tree into a string, and deserialize(s),
 * which deserializes the string back into the tree.
 *
 * For example, given the following Node class
 *
 * class Node:
 *     def __init__(self, val, left=None, right=None):
 *         self.val = val
 *         self.left = left
 *         self.right = right
 * The following test should pass:
 *
 * node = Node('root', Node('left', Node('left.left')), Node('right'))
 * assert deserialize(serialize(node)).left.left.val == 'left.left'
 */
@TreeTraversal
public class SerializeTree {
  public static class Node {
    String value;
    Node left, right;

    public Node(String value) {
      this.value = value;
    }

    public Node(String value, Node left, Node right) {
      this.value = value;
      this.left = left;
      this.right = right;
    }
  }

  public static String serialize(Node node) {
    StringBuilder builder = new StringBuilder();
    buildString(builder, node);
    return builder.toString();
  }

  private static void buildString(StringBuilder builder, Node node) {
    if (node == null) {
      builder.append("X").append(",");
      return;
    }

    builder.append(node.value).append(",");
    buildString(builder, node.left);
    buildString(builder, node.right);
  }

  public static Node deserialize(String string) {
    Deque<String> nodes = new LinkedList<>(Arrays.asList(string.split(",")));
    return buildTree(nodes);
  }

  private static Node buildTree(Deque<String> nodes) {
    String value = nodes.remove();
    if (value.equals("X")) return null;
    Node node = new Node(value);
    node.left = buildTree(nodes);
    node.right = buildTree(nodes);
    return node;
  }
}

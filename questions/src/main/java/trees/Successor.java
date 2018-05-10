package trees;

import lib.TreeNode;

/**
 * Write an algorithm to find the "next" node (i.e., in-order successor) of a given node in a binary search tree.
 * You may assume that each node has a link to its parent.
 */
public class Successor {

  public static TreeNode successor(TreeNode node) {
    if (node == null) return null;

    // node has a right subtree
    if (node.right != null) return leftmost(node.right);

    // traverse upwards
    TreeNode parent = node.parent;
    while (parent != null && parent.left != node) {
      node = parent;
      parent = parent.parent;
    }
    return parent;
  }

  private static TreeNode leftmost(TreeNode tree) {
    while (tree.left != null) tree = tree.left;
    return tree;
  }
}

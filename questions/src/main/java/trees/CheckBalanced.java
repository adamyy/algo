package trees;

import lib.TreeNode;

/**
 * Implement a function to check if a binary tree is balanced.
 *
 * A balanced tree is defined to be a tree such that the heights of the two subtrees of any node never differ by more than one.
 */
public class CheckBalanced {
  public static boolean isBalanced(TreeNode root) {
    if (root == null) return true;
    return Math.abs(height(root.left) - height(root.right)) <= 1;
  }

  private static int height(TreeNode node) {
    if (node == null) return 0;
    return 1 + Math.max(height(node.left), height(node.right));
  }
}

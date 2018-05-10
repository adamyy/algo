package trees;

import lib.TreeNode;

/**
 * Validate BST: Implement a function to check if a binary tree is a binary search tree.
 */
public class ValidateBST {
  public static boolean isBST(TreeNode root) {
    return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  private static boolean isBST(TreeNode root, int min, int max) {
    if (root == null) return true;
    if (root.val > max || root.val < min) return false;
    return isBST(root.left, min, root.val) && isBST(root.right, root.val, max);
  }
}

package trees;

import lib.TreeNode;

/**
 * Given a Binary Search Tree (BST), convert it to a Greater Tree such that
 * every key of the original BST is changed to the original key plus sum of all keys
 * greater than the original key in BST.
 *
 * Example:
 *
 * Input: The root of a Binary Search Tree like this:
 *               5
 *             /   \
 *            2     13
 *
 * Output: The root of a Greater Tree like this:
 *              18
 *             /   \
 *           20     13
 */
public class GreaterTree {
  public static TreeNode convertBST(TreeNode root) {
    return convertBSTHelper(root);
  }

  // reverse order inorder traversal
  private static int sum = 0;

  private static TreeNode convertBSTHelper(TreeNode root) {
    if (root == null) return null;
    convertBSTHelper(root.right);
    root.val += sum;
    sum = root.val;
    convertBSTHelper(root.left);
    return root;
  }
}

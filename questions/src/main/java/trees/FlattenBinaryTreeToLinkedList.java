package trees;

import lib.TreeNode;

/**
 * Given a binary tree, flatten it to a linked list in-place.
 *
 * For example, given the following tree:
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * The flattened tree should look like:
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 */
public class FlattenBinaryTreeToLinkedList {
  public static void flatten(TreeNode root) {
    flatten(root, null);
  }

  private static void flatten(TreeNode root, TreeNode prev) {
    if (root == null) return;
    TreeNode left = root.left;
    TreeNode right = root.right;
    flatten(left, right != null ? right : prev);
    flatten(right, prev);
    if (left != null) {
      root.right = left;
    } else if (right != null) {
      root.right = right;
    } else {
      root.right = prev;
    }
    root.left = null;
  }
}

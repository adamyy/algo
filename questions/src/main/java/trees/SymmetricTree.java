package trees;

import lib.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 *
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * But the following [1,2,2,null,3,null,3] is not:
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * Note:
 * Bonus points if you could solve it both recursively and iteratively.
 */
public class SymmetricTree {
  public static boolean isSymmetricRecursive(TreeNode root) {
    return root == null || isSymmetricRecursiveHelper(root.left, root.right);
  }

  private static boolean isSymmetricRecursiveHelper(TreeNode left, TreeNode right) {
    if (left == null && right == null) return true;
    if (left == null || right == null) return false;
    if (left.val != right.val) return false;
    return isSymmetricRecursiveHelper(left.left, right.right) && isSymmetricRecursiveHelper(left.right, right.left);
  }

  public static boolean isSymmetricIterative(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    if (root == null) return true;
    queue.offer(root.left);
    queue.offer(root.right);
    while (queue.size() > 1) { // has left and right
      TreeNode left = queue.poll();
      TreeNode right = queue.poll();
      if (left == null && right == null) continue;
      if (left == null || right == null) return false;
      if (left.val != right.val) return false;
      queue.offer(left.left); queue.offer(right.right);
      queue.offer(left.right); queue.offer(right.left);
    }
    return true;
  }
}

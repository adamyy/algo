package daily_challenge;

import lib.TreeNode;

/**
 * A unival tree (which stands for "universal value") is a tree where all nodes under it have the same value.
 *
 * Given the root to a binary tree, count the number of unival subtrees.
 *
 * For example, the following tree has 5 unival subtrees:
 *
 *    0
 *   / \
 *  1   0
 *     / \
 *    1   0
 *   / \
 *  1   1
 */
public class UnivalTree {
  // a subtree is unival if
  // left and right are both unival and left and right are equal
  // total number of unival subtrees at node x
  //  = number of unival subtrees at left + number of unival subtrees at right + 1 (maybe)
  public static int count(TreeNode node) {
    if (node == null) return 0;
    int leftCount = count(node.left);
    int rightCount = count(node.right);

    boolean isCurrUnival = true;
    if (node.left != null && node.left.val != node.val) isCurrUnival = false;
    if (node.right != null && node.right.val != node.val) isCurrUnival = false;

    return leftCount + rightCount + (isCurrUnival ? 1 : 0);
  }
}

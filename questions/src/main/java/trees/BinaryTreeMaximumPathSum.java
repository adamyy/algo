package trees;

import lib.TreeNode;

/**
 * Given a non-empty binary tree, find the maximum path sum.
 *
 * For this problem, a path is defined as any sequence of nodes from some starting node
 * to any node in the tree along the parent-child connections.
 * The path must contain at least one node and does not need to go through the root.
 *
 * Example 1:
 *
 * Input: [1,2,3]
 *
 *        1
 *       / \
 *      2   3
 *
 * Output: 6
 *
 * Example 2:
 *
 * Input: [-10,9,20,null,null,15,7]
 *
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * Output: 42
 */
public class BinaryTreeMaximumPathSum {
  public static int maxPathSum(TreeNode root) {
    visit(root);
    return globalMax;
  }

  private static int globalMax = Integer.MIN_VALUE;
  private static int visit(TreeNode node) {
    if (node == null) return 0;
    int left = visit(node.left);
    int right = visit(node.right);

    int leftPath = left + node.val;
    int rightPath = right + node.val;
    int completePath = left + node.val + right;

    int currentMax = max(node.val, leftPath, rightPath, completePath);
    globalMax = max(globalMax, currentMax);

    // return the max sum started from any node in subtree x and ended in x
    return max(leftPath, rightPath, node.val);
  }

  private static int max(int... arr) {
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < arr.length; i++) {
      max = Math.max(max, arr[i]);
    }
    return max;
  }
}

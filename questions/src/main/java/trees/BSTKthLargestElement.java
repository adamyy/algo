package trees;

import lib.TreeNode;

/**
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 *
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 *
 * Example 1:
 * Input: root = [3,1,4,null,2], k = 1
 * Output: 1
 *
 * Example 2:
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 * Output: 3
 *
 * Follow up:
 * What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently?
 * How would you optimize the kthSmallest routine?
 */
public class BSTKthLargestElement {
  public static int kthSmallest(TreeNode root, int k) {
    return binarySearch(root, k);
  }

  private static int binarySearch(TreeNode root, int k) {
    int rank = countNodes(root.left) + 1;
    if (k < rank) return kthSmallest(root.left, k);
    if (k > rank) return kthSmallest(root.right, k - rank); // count current node as well
    return root.val;
  }

  private static int countNodes(TreeNode node) {
    if (node == null) return 0;
    return 1 + countNodes(node.left) + countNodes(node.right);
  }
}

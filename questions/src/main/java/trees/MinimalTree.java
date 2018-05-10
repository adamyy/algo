package trees;

import lib.TreeNode;

/**
 * Given a sorted (increasing order) array with unique integer elements,
 * write an algorithm to create a binary search tree with minimal height.
 */
public class MinimalTree {
  public static TreeNode createMinimalBST(int[] arr) {
    return createMinimalBST(arr, 0, arr.length - 1);
  }

  private static TreeNode createMinimalBST(int[] arr, int start, int end) {
    if (end < start) return null;

    int mid = (start + end) / 2;
    TreeNode middleNode = new TreeNode(arr[mid]);
    middleNode.left = createMinimalBST(arr, start, mid - 1);
    middleNode.right = createMinimalBST(arr, mid + 1, end);
    return middleNode;
  }
}

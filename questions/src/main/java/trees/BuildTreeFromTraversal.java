package trees;

import lib.TreeNode;

import java.util.HashMap;

/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 *
 * Note:
 * You may assume that duplicates do not exist in the tree.
 *
 * For example, given
 *
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 * Return the following binary tree:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class BuildTreeFromTraversal {
  public static TreeNode buildTree(int[] preorder, int[] inorder) {
    if (preorder.length == 0 || inorder.length == 0 || inorder.length != preorder.length) return null;

    HashMap<Integer, Integer> inorderIndex = new HashMap<>();
    for (int index = 0; index < inorder.length; index ++) inorderIndex.put(inorder[index], index);

    return buildTree(0, 0, inorder.length, preorder, inorder, inorderIndex);
  }

  private static TreeNode buildTree(
      int preorderStart,
      int inorderStart,
      int length,
      int[] preorder,
      int[] inorder,
      HashMap<Integer, Integer> inorderIndices) {
    if (length == 0) return null;

    int rootVal = preorder[preorderStart];
    TreeNode root = new TreeNode(rootVal);
    if (length == 1) return root;

    int rootInorderIndex = inorderIndices.get(rootVal);
    int leftLength = rootInorderIndex - inorderStart;
    int rightLength = length - 1 - leftLength;
    root.left = buildTree(preorderStart + 1, inorderStart, leftLength, preorder, inorder, inorderIndices);
    root.right = buildTree(preorderStart + 1 + leftLength, rootInorderIndex + 1, rightLength, preorder, inorder, inorderIndices);
    return root;
  }
}

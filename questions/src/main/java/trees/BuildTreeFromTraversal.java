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
  public static TreeNode buildTree(int[] preOrder, int[] inOrder) {
    if (preOrder.length == 0 || inOrder.length == 0 || inOrder.length != preOrder.length) return null;

    HashMap<Integer, Integer> inOrderIndex = new HashMap<>();
    for (int index = 0; index < inOrder.length; index++) inOrderIndex.put(inOrder[index], index);

    return buildTree(0, 0, inOrder.length, preOrder, inOrder, inOrderIndex);
  }

  private static TreeNode buildTree(int preStart, int inStart, int length, int[] preOrder, int[] inOrder, HashMap<Integer, Integer> inOrderIndex) {
    if (length == 0) return null;

    int rootVal = preOrder[preStart];
    TreeNode root = new TreeNode(rootVal);
    if (length == 1) return root;

    int rootInorderIndex = inOrderIndex.get(rootVal);
    int leftLength = rootInorderIndex - inStart;
    int rightLength = length - 1 - leftLength;
    root.left = buildTree(preStart + 1, inStart, leftLength, preOrder, inOrder, inOrderIndex);
    root.right = buildTree(preStart + 1 + leftLength, rootInorderIndex + 1, rightLength, preOrder, inOrder, inOrderIndex);
    return root;
  }
}

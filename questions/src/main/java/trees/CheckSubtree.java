package trees;

import lib.TreeNode;

/**
 * Tl and T2 are two very large binary trees, with Tl much bigger than T2.
 * Create an algorithm to determine if T2 is a subtree of Tl.
 * A tree T2 is a subtree of Tl if there exists a node n in Tl such that the subtree of n is identical to T2.
 * That is, if you cut off the tree at node n, the two trees would be identical.
 */
public class CheckSubtree {

  /**
   * Given two non-empty binary trees s and t,
   * check whether tree t has exactly the same structure and node values with a subtree of s.
   * A subtree of s is a tree consists of a node in s and all of this node's descendants.
   * The tree s could also be considered as a subtree of itself.
   */
  public static boolean isBinaryTreeSubtree(TreeNode parent, TreeNode child) {
    if (parent == null && child == null) return true;
    if (parent == null || child == null) return false;

    if (parent.val == child.val && matchTrees(parent, child)) return true;

    return isBinaryTreeSubtree(parent.left, child) || isBinaryTreeSubtree(parent.right, child);
  }

  private static boolean matchTrees(TreeNode parent, TreeNode child) {
    if (parent == null && child == null) return true;
    if (parent == null || child == null) return false;

    if (parent.val != child.val) return false;
    return matchTrees(parent.left, child.left) && matchTrees(parent.right, child.right);
  }

  // trivial
  public static boolean isBSTSubtree(TreeNode parent, TreeNode child) {
    if (parent == null && child == null) return true;
    if (parent == null || child == null) return false;
    if (parent.val > child.val) return isBSTSubtree(parent.left, child);
    if (parent.val < child.val) return isBSTSubtree(parent.right, child);

    // check recursively if root value matches node val
    return isBSTSubtree(parent.left, child.left) && isBSTSubtree(parent.right, child.right);
  }
}

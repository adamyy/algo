package trees;

import lib.TreeNode;

/**
 * Design an algorithm and write code to find the first common ancestor of two nodes in a binary tree.
 * Avoid storing additional nodes in a data structure. NOTE: This is not necessarily a binary search tree.
 */
public class FirstCommonAncestor {
  // when tree nodes have access to parent
  public static TreeNode commonAncestorWithParent(TreeNode first, TreeNode second) {
    int delta = depth(first) - depth(second);
    TreeNode deeper = delta > 0 ? first : second;
    TreeNode shallower = delta > 0 ? second : first;
    deeper = traverseUpwards(deeper, Math.abs(delta));

    while (deeper != shallower && deeper != null && shallower != null) {
      deeper = deeper.parent;
      shallower = shallower.parent;
    }

    return deeper == null || shallower == null ? null : deeper;
  }

  private static TreeNode traverseUpwards(TreeNode node, int delta) {
    while (delta-- > 0 && node != null) node = node.parent;
    return node;
  }

  private static int depth(TreeNode node) {
    int depth = 0;
    while (node != null) {
      node = node.parent;
      depth++;
    }
    return depth;
  }

  public static TreeNode commonAncestorWithoutParent(TreeNode root, TreeNode first, TreeNode second) {
    if (!covers(root, first) || !covers(root, second)) return null;
    return commonAncestorWithoutParentHelper(root, first, second);
  }

  private static TreeNode commonAncestorWithoutParentHelper(TreeNode root, TreeNode first, TreeNode second) {
    if (root == null || root == first || root == second) return root;

    boolean firstOnLeft = covers(root.left, first);
    boolean secondOnLeft = covers(root.left, second);

    // when two nodes are not on the same side, we have found the first common ancestor
    if (firstOnLeft != secondOnLeft) return root;

    TreeNode subtree = firstOnLeft ? root.left : root.right;
    return commonAncestorWithoutParentHelper(subtree, first, second);
  }

  private static boolean covers(TreeNode root, TreeNode node) {
    if (root == null) return false;
    if (root == node) return true;
    return covers(root.left, node) || covers(root.right, node);
  }

  private static TreeNode getSibiling(TreeNode node) {
    if (node == null || node.parent == null) return null;
    TreeNode parent = node.parent;
    return parent.left == node ? parent.right : parent.left;
  }

  // simplified
  public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode first, TreeNode second) {
    if (root == null || root == first || root == second) return root;
    TreeNode leftLCA = lowestCommonAncestor(root.left, first, second);
    TreeNode rightLCA = lowestCommonAncestor(root.right, first, second);
    if (leftLCA != null && rightLCA != null) return root;
    else if (leftLCA != null) return leftLCA;
    else return rightLCA;
  }
}

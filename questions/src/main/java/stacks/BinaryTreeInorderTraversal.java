package stacks;

import lib.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 *
 * Example:
 * Input: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * Output: [1,3,2]
 *
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 */
public class BinaryTreeInorderTraversal {
  public static List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    TreeNode curr = root;
    while (curr != null || !stack.empty()) {
      // traverse to each node's left child
      while (curr != null) {
        stack.add(curr);
        curr = curr.left;
      }
      // backtrack to higher level node
      curr = stack.pop();
      result.add(curr.val);
      // switch to higher level node's right branch
      curr = curr.right;
    }

    return result;
  }
}

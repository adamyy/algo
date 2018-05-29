package stacks;

import lib.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Pattern;

/**
 * Given a binary tree, return the preOrder traversal of its nodes' values.
 *
 * Example:
 *
 * Input: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * Output: [1,2,3]
 *
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 */
public class BinaryTreePreorderTraversal {
  public static List<Integer> preOrderTraversalRecursive(TreeNode root) {
    return preOrderTraversalRecursiveHelper(root, new LinkedList<>());
  }
  
  private static List<Integer> preOrderTraversalRecursiveHelper(TreeNode node, List<Integer> result) {
    if (node == null) return result;
    result.add(node.val);
    preOrderTraversalRecursiveHelper(node.left, result);
    preOrderTraversalRecursiveHelper(node.right, result);
    return result;
  }

  public static List<Integer> preOrderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    stack.add(root);

    while (!stack.empty()) {
      TreeNode curr = stack.pop();
      result.add(curr.val);

      do {
        // push the right one so it will be popped later when we backtrack
        if (curr.right != null) stack.push(curr.right);
        if (curr.left != null) result.add(curr.left.val);
        curr = curr.left;
      } while (curr != null);
    }

    return result;
  }
}

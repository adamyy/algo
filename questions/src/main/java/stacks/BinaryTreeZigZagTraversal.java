package stacks;

import lib.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * return its zigzag level order traversal as:
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 */
public class BinaryTreeZigZagTraversal {
  public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    if (root == null) return null;

    List<List<Integer>> result = new ArrayList<>();
    Stack<TreeNode> currLevel = new Stack<>();
    Stack<TreeNode> nextLevel = new Stack<>();

    currLevel.push(root);
    boolean goingLeft = true;

    while (!(currLevel.empty() && nextLevel.empty())) {
      List<Integer> currentList = new ArrayList<>();

      while (!currLevel.empty()) {
        TreeNode curr = currLevel.pop();

        if (goingLeft) {
          if (curr.left != null) nextLevel.push(curr.left);
          if (curr.right != null) nextLevel.push(curr.right);
        } else {
          if (curr.right != null) nextLevel.push(curr.right);
          if (curr.left != null) nextLevel.push(curr.left);
        }

        currentList.add(curr.val);
      }

      result.add(currentList);

      // go zig zag
      goingLeft = !goingLeft;

      // swap the two stack
      Stack<TreeNode> temp = currLevel;
      currLevel = nextLevel;
      nextLevel = temp;
    }

    return result;
  }
}

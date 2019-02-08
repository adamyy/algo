package trees;

import lib.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, retrieve the left most node for every level
 */
public class LeftmostNodes {
  public static List<Integer> leftmostNodes(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    List<Integer> result = new LinkedList<>();

    while (!queue.isEmpty()) {
      int levelSize = queue.size();

      for (int i = 0; i < levelSize; i++) {
        TreeNode node = queue.remove();
        if (i == 0) result.add(node.val); // leftmost node
        if (node.left != null) queue.offer(node.left);
        if (node.right != null) queue.offer(node.right);
      }
    }

    return result;
  }
}

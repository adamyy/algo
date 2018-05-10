package trees;

import lib.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Given a binary tree, design an algorithm which creates a linked list of all the nodes at each depth
 * (e.g., if you have a tree with depth D, you'll have D linked lists).
 */
public class ListsOfDepths {
  public static ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root) {
    return createLevelLinkedList(root, new ArrayList<>(),0);
  }

  private static ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root, ArrayList<LinkedList<TreeNode>> result, int level) {
    if (root == null) return result;

    // level not contained in list
    if (level >= result.size()) result.add(new LinkedList<>());
    LinkedList<TreeNode> currentList = result.get(level);
    currentList.add(root);
    createLevelLinkedList(root.left, result, level + 1);
    createLevelLinkedList(root.right, result, level + 1);
    return result;
  }

  public static ArrayList<LinkedList<TreeNode>> createLevelLinkedListIterative(TreeNode root) {
    ArrayList<LinkedList<TreeNode>> result = new ArrayList<>();
    LinkedList<TreeNode> currentList = new LinkedList<>();
    if (root != null) currentList.add(root);

    while (!currentList.isEmpty()) {
      result.add(currentList);
      LinkedList<TreeNode> parentList = currentList;
      currentList = new LinkedList<>();
      for (TreeNode parent: parentList) {
        if (parent.left != null) currentList.add(parent.left);
        if (parent.right != null) currentList.add(parent.right);
      }
    }

    return result;
  }
}

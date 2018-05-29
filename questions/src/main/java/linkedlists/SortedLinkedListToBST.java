package linkedlists;

import lib.ListNode;
import lib.TreeNode;

/**
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 * For this problem, a height-balanced binary tree is defined as a binary tree
 * in which the depth of the two subtrees of every node never differ by more than 1.
 *
 * Example:
 *
 * Given the sorted linked list: [-10,-3,0,5,9],
 *
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 */
public class SortedLinkedListToBST {
  // sorted linked list is an inOrder traversal
  public static TreeNode sortedListToBSTInOrder(ListNode head) {
    if (head == null) return null;

    int length = 0;
    ListNode runner = head;
    while (runner != null) {
      runner = runner.next;
      length++;
    }

    node = head;

    return inOrder(0, length - 1);
  }

  // must traverse tree inorderly
  static ListNode node;
  private static TreeNode inOrder(int start, int end) {
    if (start > end) return null;
    int mid = (start + end) / 2;

    TreeNode left = inOrder(start, mid - 1);
    TreeNode tree = new TreeNode(node.val);
    node = node.next;
    TreeNode right = inOrder(mid + 1, end);
    tree.left = left;
    tree.right = right;
    return tree;
  }
}

package lib;

public class TreeNode {
  public int val;
  public TreeNode left;
  public TreeNode right;

  public TreeNode(int val) {
    this.val = val;
  }

  public TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }

  public static TreeNode buildTreeFromArray(Integer... arr) {
    return buildTreeFromArrayRecursive(1, arr);
  }

  private static TreeNode buildTreeFromArrayRecursive(int index, Integer... arr) {
    if (index > arr.length) return null;
    if (arr[index - 1] == null) return null;

    TreeNode node = new TreeNode(arr[index - 1]);

    node.left = buildTreeFromArrayRecursive(index * 2, arr);
    node.right = buildTreeFromArrayRecursive(index * 2 + 1, arr);

    return node;
  }
}

package lib;

public class TreeNode {
  public int val;
  public TreeNode left;
  public TreeNode right;
  public TreeNode parent;

  public TreeNode(int val) {
    this.val = val;
  }

  public TreeNode(int val, TreeNode parent) {
    this.val = val;
    this.parent = parent;
  }

  public TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    TreeNode treeNode = (TreeNode) o;

    if (val != treeNode.val) return false;
    if (left != null ? !left.equals(treeNode.left) : treeNode.left != null) return false;
    return right != null ? right.equals(treeNode.right) : treeNode.right == null;
  }

  @Override
  public int hashCode() {
    int result = val;
    result = 31 * result + (left != null ? left.hashCode() : 0);
    result = 31 * result + (right != null ? right.hashCode() : 0);
    return result;
  }

  public static TreeNode buildTreeFromArray(Integer... arr) {
    return buildTreeFromArrayRecursive(null, 1, arr);
  }

  private static TreeNode buildTreeFromArrayRecursive(TreeNode parent, int index, Integer... arr) {
    if (index > arr.length) return null;
    if (arr[index - 1] == null) return null;

    TreeNode node = new TreeNode(arr[index - 1], parent);

    node.left = buildTreeFromArrayRecursive(node, index * 2, arr);
    node.right = buildTreeFromArrayRecursive(node, index * 2 + 1, arr);

    return node;
  }
}

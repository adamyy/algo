package trees;

import lib.TreeNode;

import java.util.HashMap;

/**
 * You are given a binary tree in which each node contains an integer value (which might be positive or negative).
 * Design an algorithm to count the number of paths that sum to a given value.
 * The path does not need to start or end at the root or a leaf,
 * but it must go downwards (traveling only from parent nodes to child nodes).
 *
 * Example:
 *
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *
 *       10
 *      /  \
 *     5   -3
 *    / \    \
 *   3   2   11
 *  / \   \
 * 3  -2   1
 *
 * Return 3. The paths that sum to 8 are:
 *
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3. -3 -> 11
 */
public class PathsWithSum {
  public static int pathsWithSum(TreeNode root, int sum) {
    return pathsWithSumOptimized(root, sum, 0, new HashMap<>());
  }

  private static int pathsWithSumPreOptimize(TreeNode root, int currentSum, int targetSum) {
    if (root == null) return 0;

    // include current node
    int totalPaths = 0;

    // check if current node suffice
    if (root.val + currentSum == targetSum) totalPaths++;

    // include the current node in the path
    totalPaths += pathsWithSumPreOptimize(root.left, currentSum + root.val, targetSum);
    totalPaths += pathsWithSumPreOptimize(root.right, currentSum + root.val, targetSum);

    // don't include the current node in the path, "restart" the sum in the child node
    totalPaths += pathsWithSumPreOptimize(root.left, 0, targetSum);
    totalPaths += pathsWithSumPreOptimize(root.right, 0, targetSum);

    return totalPaths;
  }

  private static int pathsWithSumOptimized(
      TreeNode root,
      int targetSum,
      int runningSum,
      HashMap<Integer, Integer> previousRunningSumCounts) {
    if (root == null) return 0;

    int totalPaths = 0;

    // if runningSum equals targetSum, one additional path starts at root
    if (runningSum == targetSum) totalPaths++;

    // accumulate the running sum
    runningSum += root.val;

    // look for the difference as targetSum == (currRunningSum - prevRunningSum)
    totalPaths += previousRunningSumCounts.getOrDefault(runningSum - targetSum, 0);

    previousRunningSumCounts.put(runningSum, previousRunningSumCounts.getOrDefault(runningSum, 0) + 1);
    totalPaths += pathsWithSumOptimized(root.left, targetSum, runningSum, previousRunningSumCounts);
    totalPaths += pathsWithSumOptimized(root.right, targetSum, runningSum, previousRunningSumCounts);
    previousRunningSumCounts.put(runningSum, previousRunningSumCounts.getOrDefault(runningSum, 0) - 1);

    return totalPaths;
  }
}

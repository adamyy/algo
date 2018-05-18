package recursions_dynamic_programming;

/**
 * You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -.
 * For each integer, you should choose one from + and - as its new symbol.
 *
 * Find out how many ways to assign symbols to make sum of integers equal to target S.
 *
 * Example 1:
 * Input: nums is [1, 1, 1, 1, 1], S is 3.
 * Output: 5
 * Explanation:
 *
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 *
 * There are 5 ways to assign symbols to make the sum of nums be target 3.
 * Note:
 * The length of the given array is positive and will not exceed 20.
 * The sum of elements in the given array will not exceed 1000.
 * Your output answer is guaranteed to be fitted in a 32-bit integer.
 */
public class TargetSum {
  /**
   * sum(P) - sum(N) = target;
   * sum(P) - sum(N) + sum(P) + sum(N) = target + sum(P) + sum(N);
   * 2 * sum(P) = target + sum(all)
   * sum(P) = (target + sum(all)) / 2
   */
  public static int findTargetSumWays(int[] nums, int target) {
    int totalSum = 0;
    for (int num: nums) totalSum += num;
    if (totalSum < target || (target + totalSum) % 2 != 0) return 0;

    // find the subset of nums that sum up to the positive target
    target = (target + totalSum) / 2;
    int[] dp = new int[target + 1];
    dp[0] = 1;

    for (int num: nums) {
      for (int i = target; i >= num; i--) {
        dp[i] += dp[i - num];
      }
    }

    return dp[target];
  }

  public static int findTargetSumExplained(int[] nums, int target) {
    int totalSum = 0;
    for (int num: nums) totalSum += num;
    if (totalSum < target || (target + totalSum) % 2 != 0) return 0;

    target = (target + totalSum) / 2;
    int[][] solution = new int[nums.length + 1][target + 1];

    // base case - we can always find target == 0 (empty subset)
    for (int i = 0; i < nums.length + 1; i++) solution[i][0] = 1;

    for (int i = 1; i <= nums.length; i++) {
      for (int j = 1; j <= target; j++) {
        solution[i][j] += solution[i - 1][j];
        if (j >= nums[i - 1]) solution[i][j] += solution[i - 1][j - nums[i - 1]];
      }
    }
    return solution[nums.length][target];
  }
}

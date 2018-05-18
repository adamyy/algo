package recursions_dynamic_programming;

/**
 * Given a non-empty array containing only positive integers,
 * find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
 *
 * Note:
 * Each of the array element will not exceed 100.
 * The array size will not exceed 200.
 * Example 1:
 *
 * Input: [1, 5, 11, 5]
 *
 * Output: true
 *
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 * Example 2:
 *
 * Input: [1, 2, 3, 5]
 *
 * Output: false
 *
 * Explanation: The array cannot be partitioned into equal sum subsets.
 */
public class PartialEqualSubsetSum {
  public static boolean canPartition(int[] nums) {
    int totalSum = 0;
    for (int num : nums) totalSum += num;
    if (totalSum % 2 == 1) return false;

    int targetSum = totalSum >> 1;
    boolean[] solution = new boolean[targetSum + 1];
    solution[0] = true;

    for (int num: nums) {
      for (int i = targetSum; i >= num; i--) {
        solution[i] = solution[i] || solution[i - num];
      }
    }

    return solution[targetSum];
  }

  public static boolean canPartitionExplained(int[] nums) {
    int totalSum = 0;
    for (int num : nums) totalSum += num;
    if (totalSum % 2 == 1) return false;

    int targetSum = totalSum >> 1;

    // solution[i][j] -> can we partition using the first i numbers to make sum j
    boolean[][] solution = new boolean[nums.length + 1][totalSum + 1];

    // base cass
    // empty set for sum = 0
    for (int i = 0; i < nums.length + 1; i++) solution[i][0] = true;
    // we can't make any subset for nonzero sum
    for (int i = 1; i < totalSum + 1; i++) solution[0][i] = false;

    for (int i = 1; i <= nums.length; i++) {
      for (int j = 1; j <= targetSum; j++) {
        // if we can make sum j without using the ith number,
        // ofc we can make it with ith number (excluded from the subset) as well
        solution[i][j] = solution[i - 1][j];
        if (!solution[i][j] && j >= nums[i - 1]) solution[i][j] = solution[i - 1][j - nums[i - 1]];
      }
    }
    return solution[nums.length][totalSum];
  }
}

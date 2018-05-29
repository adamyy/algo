package recursions_dynamic_programming;

/**
 * Given a positive integer n, break it into the sum of at least two positive integers
 * and maximize the product of those integers. Return the maximum product you can get.
 *
 * For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).
 *
 * Note: You may assume that n is not less than 2 and not larger than 58.
 */
public class IntegerBreak {
  // typical knapsack
  // capacity: n
  // items available to choose: 1 ~ n - 1
  // value: items product
  public static int integerBreak(int n) {
    int[] dp = new int[n + 1];
    dp[0] = 1;
    int max = 0;
    for (int i = 1; i < n; i++) { // i is the item we can choose, notice you cannot choose n
      for (int j = i; j <= n; j++) { // j is the sum of items we are choosing from
        dp[j] = Math.max(dp[j], dp[j - i] * i);
        if (j == n) max = Math.max(max, dp[j]);
      }
    }
    return max;
  }
}

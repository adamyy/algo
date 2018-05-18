package recursions_dynamic_programming;

/**
 * You are given coins of different denominations and a total amount of money amount.
 * Write a function to compute the fewest number of coins that you need to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 * <p>
 * Example 1:
 * coins = [1, 2, 5], amount = 11
 * return 3 (11 = 5 + 5 + 1)
 * <p>
 * Example 2:
 * coins = [2], amount = 3
 * return -1.
 * <p>
 * Note:
 * You may assume that you have an infinite number of each kind of coin.
 */
public class FewestCoinChange {
  public static int coinChange(int[] coins, int total) {
    if (coins == null || coins.length == 0) return 0;
    int[] memo = new int[total + 1];
    for (int amount = 1; amount <= total; amount++) {
      memo[amount] = Integer.MAX_VALUE;
      for (int coin : coins) {
        if (amount >= coin && memo[amount - coin] != Integer.MAX_VALUE) {
          memo[amount] = Math.min(memo[amount], memo[amount - coin] + 1);
        }
      }
    }
    return memo[total] == Integer.MAX_VALUE ? -1 : memo[total];
  }
}

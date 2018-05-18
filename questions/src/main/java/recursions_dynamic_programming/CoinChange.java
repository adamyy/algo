package recursions_dynamic_programming;

/**
 * Coins: Given an in infinite number of quarters (25 cents), dimes (10 cents), nickels (5 cents), and pennies (1 cent),
 * write code to calculate the number of ways of representing n cents.
 */
public class CoinChange {
  public static int coinChange(int n, int[] coins) {
    int[] memo = new int[n + 1];
    memo[n] = -1;
    return coinChange(n, coins, memo);
  }

  private static int coinChange(int n, int[] coins, int[] memo) {
    if (n < 0) return 0;
    if (n == 0) return 1;
    if (memo[n] > 0) return memo[n];
    for (int coin: coins) {
      if (n >= coin) {
        memo[n] += coinChange(n - coin, coins, memo);
      }
    }
    return memo[n];
  }
}

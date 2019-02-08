package daily_challenge;

import java.util.Arrays;
import java.util.Collections;

/**
 * This problem was asked by Facebook.
 *
 * A builder is looking to build a row of N houses that can be of K different colors.
 * He has a goal of minimizing cost while ensuring that no two neighboring houses are of the same color.
 *
 * Given an N by K matrix where the nth row and kth column represents the cost to build the nth house with kth color,
 * return the minimum cost which achieves this goal.
 *
 */
public class MinimumBuildCost {
  /**
   * @param matrix an N by K matrix where the nth row and kth column represents the cost to build the nth house with kth color
   * @return the minimum cost which minimize cost while ensuring that no two neighboring houses are of the same color
   */
  public static int minimumCost(int[][] matrix) {
    final int n = matrix.length;
    final int k = matrix[0].length;

    // the minimum cost of building the first n house with k as the last color
    Integer[][] dp = new Integer[n + 1][k + 1];
    // dp[i][j] = matrix[i - 1][j - 1] + Math.min(dp[i][1 -> j], dp[i][j + 1 -> ])

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= k; j++) {
        dp[i][j] = matrix[i - 1][j - 1] +
            Math.min(
                Collections.min(Arrays.asList(Arrays.copyOfRange(dp[i - 1], 0, j))),
                Collections.min(Arrays.asList(Arrays.copyOfRange(dp[i - 1], j + 1, k)))
            );
      }
    }

    return Collections.min(Arrays.asList(dp[n]));
  }
}

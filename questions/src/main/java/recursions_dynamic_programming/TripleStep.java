package recursions_dynamic_programming;

import java.util.Arrays;

/**
 * A child is running up a staircase with n steps and can hop either 1 step, 2 steps, or 3 steps at a time.
 * Implement a method to count how many possible ways the child can run up the stairs.
 */
public class TripleStep {
  public static int tripleStep(int n) {
    int[] memo = new int[n + 1];
    Arrays.fill(memo, -1);
    return tripleStep(n, memo);
  }

  private static int tripleStep(int n, int[] memo) {
    if (n < 0) return 0;
    if (n == 0) return 1;
    if (memo[n] > -1) return memo[n];

    memo[n] = tripleStep(n - 1, memo) + tripleStep(n - 2, memo) + tripleStep(n - 3, memo);
    return memo[n];
  }
}

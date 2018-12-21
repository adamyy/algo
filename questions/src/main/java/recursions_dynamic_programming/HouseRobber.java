package recursions_dynamic_programming;

/**
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed, the only constraint stopping you from
 * robbing each of them is that adjacent houses have security system connected
 * and it will automatically contact the police if two adjacent houses were broken into on the same night.
 *
 * Given a list of non-negative integers representing the amount of money of each house,
 * determine the maximum amount of money you can rob tonight without alerting the police.
 *
 * Example 1:
 *
 * Input: [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 *              Total amount you can rob = 1 + 3 = 4.
 * Example 2:
 *
 * Input: [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 *              Total amount you can rob = 2 + 9 + 1 = 12.
 */
public class HouseRobber {
  public static int rob(int[] houses) {
    int[] memo = new int[houses.length];
    return rob(houses, houses.length - 1, memo);
  }

  private static int rob(int[] houses, int end, int[] memo) {
    if (end < 0) return 0;
    if (memo[end] > 0) return memo[end];

    int robFirst = rob(houses, end - 2, memo) + houses[end];
    int robSecond = rob(houses, end - 1, memo);

    return Math.max(robFirst, robSecond);
  }

  private static int robConstantSpace(int[] houses) {
    int rob = 0;
    int notRob = 0;
    for (int house : houses) {
      int robCurr = notRob + house;
      notRob = Math.max(notRob, rob);
      rob = robCurr;
    }
    return Math.max(rob, notRob);
  }
}
